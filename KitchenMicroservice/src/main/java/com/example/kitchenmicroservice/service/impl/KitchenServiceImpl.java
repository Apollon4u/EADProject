package com.example.kitchenmicroservice.service.impl;

import com.example.kitchenmicroservice.model.Kitchen;
import com.example.kitchenmicroservice.model.Product;
import com.example.kitchenmicroservice.repository.KitchenRepository;
import com.example.kitchenmicroservice.service.KitchenService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final RestTemplate restTemplate;
    private final KitchenRepository kitchenRepository;

    @Override
    public Kitchen getById(Long productId) {
        return kitchenRepository.getById(productId);
    }

    @HystrixCommand(
            fallbackMethod = "getProductsByIdFallback",
            threadPoolKey = "getProductsById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public List<Product> getProductsById(Long kitchenId) {
        return restTemplate.getForObject("http://product-service/product//get-by-kitchen" + kitchenId, List.class);
    }

    public List<Product> getProductsByIdFallback(Long productId) {
        return Collections.emptyList();
    }

    @Override
    public void create(Kitchen kitchen) {
        kitchenRepository.save(kitchen);
    }

    @Override
    public List<Kitchen> getAll() {
        return kitchenRepository.findAll();
    }
}
