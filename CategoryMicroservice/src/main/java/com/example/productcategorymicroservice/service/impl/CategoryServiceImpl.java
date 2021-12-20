package com.example.productcategorymicroservice.service.impl;

import com.example.productcategorymicroservice.model.Category;
import com.example.productcategorymicroservice.model.Product;
import com.example.productcategorymicroservice.repository.CategoryRepository;
import com.example.productcategorymicroservice.service.CategoryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductsFallback",
            threadPoolKey = "getProducts",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="90"),
                    @HystrixProperty(name="maxQueueSize", value="40"),
            }
    )
    public List<Product> getProducts(Long id) {
        List<Product> products  = restTemplate.getForObject("http://product-service/product/category"+ id, List.class);
        return products;
    }

    public List<Product> getProductsFallback(Long id) {
        return Collections.emptyList();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
