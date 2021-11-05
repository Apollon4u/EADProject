package com.example.ordermicroservice.service.impl;

import com.example.ordermicroservice.converter.OrderConverter;
import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.model.entity.Order;
import com.example.ordermicroservice.repository.OrderRepository;
import com.example.ordermicroservice.service.OrderService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private RestTemplate restTemplate;

    @Override
    public OrderDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderDto.from(order);
    }

//    @HystrixCommand(
//            fallbackMethod = "getOrderByIdFallback",
//            threadPoolKey = "getOrderById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            })
//    public OrderDto getOrderById(Long id) {
//        return restTemplate.getForObject("http://order-service/order/get-by-id" + id, OrderDto.class);
//    }

    @HystrixCommand(
            fallbackMethod = "getOrderByIdFallback",
            threadPoolKey = "getOrderById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            },
            commandKey = "getOrderById",
            commandProperties = {
                    @HystrixProperty(name = "requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "sleepWindowInMilliseconds", value = "7000")
            }
    )
    public OrderDto getOrderById(Long id) {
        return restTemplate.getForObject("http://order-service/order/get-by-id" + id, OrderDto.class);
    }

    public OrderDto getOrderByIdFallback(Long orderId) {
        OrderDto dto = new OrderDto();
        dto.setUserId("user id is not available: Service Unavailable");
        dto.setTotalPrice(-1D);
        return dto;
    }

    @Override
    public void createOrder(OrderDto dto) {
        orderRepository.save(orderConverter.convert(dto));
    }

    @Override
    public void addDish(Long orderId, Long dishId) {
        orderRepository.getById(orderId).getDishIds().add(dishId);
    }
}
