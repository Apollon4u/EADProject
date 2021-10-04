package com.example.productmicroservice.service.impl;

import com.example.productmicroservice.converter.ProductConverter;
import com.example.productmicroservice.model.entity.Product;
import com.example.productmicroservice.model.dto.ProductDto;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.getById(productId);
        return productConverter.fill(product);
    }
}
