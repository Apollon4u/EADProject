package com.example.kitchenmicroservice.service;

import com.example.kitchenmicroservice.model.Kitchen;
import com.example.kitchenmicroservice.model.Product;

import java.util.List;

public interface KitchenService {
    Kitchen getById(Long productId);
    List<Product> getProductsById(Long productId);
    void create(Kitchen kitchen);
    List<Kitchen> getAll();
}
