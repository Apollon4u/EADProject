package com.example.productmicroservice.controller;

import com.example.productmicroservice.model.dto.ProductDto;
import com.example.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-product")
    public ResponseEntity<ProductDto> getProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }
}
