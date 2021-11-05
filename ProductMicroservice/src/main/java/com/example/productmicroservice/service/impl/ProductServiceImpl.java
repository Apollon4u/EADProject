package com.example.productmicroservice.service.impl;

import com.example.productmicroservice.converter.ProductConverter;
import com.example.productmicroservice.model.entity.Product;
import com.example.productmicroservice.model.dto.ProductDto;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.service.ProductService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.getById(productId);
        return productConverter.fill(product);
    }

    public void createProduct(String name) {
        Product product = new Product();
        product.setActive(false);
        product.setName(name);
        product.setQuantity(0L);
        productRepository.save(product);
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

//    @HystrixCommand(
//            fallbackMethod = "getProductByIdFallback",
//            threadPoolKey = "getProductById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            })
//    public ProductDto getProductById(Long id) {
//        return restTemplate.getForObject("http://product-service/product/get-product" + id, ProductDto.class);
//    }

    @HystrixCommand(
            fallbackMethod = "getProductByIdFallback",
            threadPoolKey = "getProductById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            },
            commandKey = "getProductById",
            commandProperties = {
                    @HystrixProperty(name = "requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "errorThresholdPercentage", value = "25"),
                    @HystrixProperty(name = "sleepWindowInMilliseconds", value = "1000")
            }
    )
    public ProductDto getProductById(Long id) {
        return restTemplate.getForObject("http://product-service/product/get-product" + id, ProductDto.class);
    }

    public ProductDto getProductByIdFallback(Long id) {
        ProductDto productDto = new ProductDto();
        productDto.setName("Name is not available: Service Unavailable");
        productDto.setId(0L);
        return productDto;
    }
}
