package com.example.stockmicroservice.controller;

import com.example.stockmicroservice.model.dto.StockDto;
import com.example.stockmicroservice.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final IStockService stockService;

    @GetMapping("/get_stock")
    public ResponseEntity<StockDto> getStock(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(stockService.getStock())
    }
}
