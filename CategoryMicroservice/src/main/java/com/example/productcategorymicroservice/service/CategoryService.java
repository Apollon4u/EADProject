package com.example.productcategorymicroservice.service;

import com.example.productcategorymicroservice.model.Product;
import com.example.productcategorymicroservice.model.Category;

import java.util.List;

public interface CategoryService {
    List<Product> getProducts(Long id);
    List<Category> getCategories();
    void addCategory(Category category);
    Category getCategoryById(Long id);
}
