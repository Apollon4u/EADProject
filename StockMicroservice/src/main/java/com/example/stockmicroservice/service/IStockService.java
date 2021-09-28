package com.example.stockmicroservice.service;

import com.example.stockmicroservice.model.dto.StockDto;

public interface IStockService {
    StockDto getStock(Long stockId);
}
