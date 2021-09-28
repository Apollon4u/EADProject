package com.example.stockmicroservice.service.impl;

import com.example.stockmicroservice.converter.StockConverter;
import com.example.stockmicroservice.model.dto.StockDto;
import com.example.stockmicroservice.model.entity.Stock;
import com.example.stockmicroservice.repository.StockRepository;
import com.example.stockmicroservice.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService {

    private final StockRepository stockRepository;
    private final StockConverter stockConverter;

    @Override
    public StockDto getStock(Long stockId) {
        Stock stock = stockRepository.getById(stockId);
        return stockConverter.fill(stock);
    }
}
