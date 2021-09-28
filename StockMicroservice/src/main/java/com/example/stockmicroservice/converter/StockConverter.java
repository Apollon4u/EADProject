package com.example.stockmicroservice.converter;

import com.example.stockmicroservice.model.dto.StockDto;
import com.example.stockmicroservice.model.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockConverter {

    public StockDto fill(Stock source) {
        return new StockDto()
                .setId(source.getId())
                .setActive(source.getActive())
                .setActive(source.getActive())
                .setAddress(source.getAddress())
                .setStoreName(source.getStoreName())
                .setPickupAvailable(source.getPickupAvailable());
    }
}
