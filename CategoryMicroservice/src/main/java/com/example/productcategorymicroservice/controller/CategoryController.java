package com.example.productcategorymicroservice.controller;

import com.example.productcategorymicroservice.model.Category;
import com.example.productcategorymicroservice.model.Product;
import com.example.productcategorymicroservice.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Api("Operations with categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get-all")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategory(@PathVariable Long id) {
        return categoryService.getProducts(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
