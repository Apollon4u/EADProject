package com.example.productmicroservice.service.impl;

import com.example.productmicroservice.model.Product;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findProductById(productId);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getByKitchenId(Long kitchenId) {
        return productRepository.findByKitchenId(kitchenId);
    }

    @Override
    public void changeActivity(Boolean status, Long id) {
        Product product = productRepository.findProductById(id);
        product.setActive(status);
        productRepository.save(product);
    }

    @Override
    public void addQuantity(Long quantity, Long id) {
        Product product = productRepository.findProductById(id);
        product.setQuantity(product.getQuantity() + quantity);
        productRepository.save(product);
    }

    @Override
    public void deleteQuantity(Long quantity, Long id) {
        Product product = productRepository.findProductById(id);
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    @Override
    public String getProductName(Long id) {
        return productRepository.findProductById(id).getName();
    }
}
