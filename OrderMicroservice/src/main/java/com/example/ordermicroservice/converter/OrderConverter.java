package com.example.ordermicroservice.converter;

import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConverter implements Converter<OrderDto, Order> {
    @Override
    public Order convert(OrderDto source) {
        Order order = new Order();
        order.setUserId(source.getUserId());
        order.setDateCreated(source.getDateCreated());
        order.setDishIds(source.getDishIds());
        order.setStatus(source.getStatus());
        order.setTotalPrice(source.getTotalPrice());
        return order;
    }
}
