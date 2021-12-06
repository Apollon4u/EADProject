package com.example.productmicroservice.service;

import com.example.productmicroservice.model.Product;

public interface ProductService {
    Product getProduct(Long productId);
    void createProduct(String name);
    void changeActivity(Boolean status, Long id);
    void addQuantity(Long quantity, Long id);
    void deleteQuantity(Long quantity, Long id);
    String getProductName(Long id);
}
