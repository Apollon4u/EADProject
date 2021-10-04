package com.example.productmicroservice.service;

import com.example.productmicroservice.model.dto.ProductDto;

public interface ProductService {
    ProductDto getProduct(Long productId);
}
