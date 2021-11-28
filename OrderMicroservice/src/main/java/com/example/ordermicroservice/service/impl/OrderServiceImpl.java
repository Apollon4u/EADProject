package com.example.ordermicroservice.service.impl;

import com.example.ordermicroservice.model.Order;
import com.example.ordermicroservice.repository.OrderRepository;
import com.example.ordermicroservice.service.OrderService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private RestTemplate restTemplate;

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.getById(orderId);
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

//    @HystrixCommand(
//            fallbackMethod = "getOrderByIdFallback",
//            threadPoolKey = "getOrderById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            },
//            commandKey = "getOrderById",
//            commandProperties = {
//                    @HystrixProperty(name = "requestVolumeThreshold", value = "10"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
//                    @HystrixProperty(name = "sleepWindowInMilliseconds", value = "2000"),
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
//                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")
//            }
//    )
    public Order getOrderById(Long id) {
        return restTemplate.getForObject("http://order-service/order/get-by-id" + id, Order.class);
    }

    public Order getOrderByIdFallback(Long orderId) {
        Order dto = new Order();
        dto.setUserId("user id is not available: Service Unavailable");
        dto.setTotalPrice(-1D);
        return dto;
    }

    public String getUserEmail(Long id) {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://user-service/user/get-email/" + id,
                HttpMethod.GET, entity, String.class).getBody();
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void addDish(Long orderId, Long dishId) {
        orderRepository.getById(orderId).getDishIds().add(dishId);
    }
}
