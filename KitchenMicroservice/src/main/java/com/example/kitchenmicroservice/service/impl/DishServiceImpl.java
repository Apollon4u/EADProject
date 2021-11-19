package com.example.kitchenmicroservice.service.impl;

import com.example.kitchenmicroservice.model.Dish;
import com.example.kitchenmicroservice.repository.DishRepository;
import com.example.kitchenmicroservice.service.DishService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    @Autowired
    private RestTemplate restTemplate;
    private final DishRepository dishRepository;

    @Override
    public Dish getDish(Long dishId) {
        return dishRepository.getById(dishId);
    }

    @Override
    public Double getPrice(Long dishId) {
        return getDish(dishId).getPrice();
    }

//    @HystrixCommand(fallbackMethod = "getPriceByDishIdFallback")
//    public Double getPriceByDishId(Long id) {
//        return restTemplate.getForObject("http://kitchen-service/dishes/get-by-id/" + id, Double.class);
//    }

//    @HystrixCommand(
//            fallbackMethod = "getDishByIdFallback",
//            threadPoolKey = "getDishById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            },
//            commandKey = "getOrderById",
//            commandProperties = {
//                    @HystrixProperty(name = "requestVolumeThreshold", value = "10"),
//                    @HystrixProperty(name = "errorThresholdPercentage", value = "50"),
//                    @HystrixProperty(name = "sleepWindowInMilliseconds", value = "3000")
//            }
//    )
    public Dish getDishById(Long id) {
        return restTemplate.getForObject("http://kitchen-service/dishes/get-by-id" + id, Dish.class);
    }

    public Dish getDishByIdFallback(Long id) {
        Dish dish = new Dish();
        dish.setPrice(0D);
        dish.setName("");
        return dish;
    }

    public Double getPriceByDishIdFallback(Long id) {
        return 0.0;
    }

    @Override
    public void createDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public String getProductName(Long id) {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://product-service/product/get-product-name/" + id,
                HttpMethod.GET, entity, String.class).getBody();
    }

    @Override
    public void addProduct(Long dishId, Long productId) {
        Dish dish = dishRepository.findDishById(dishId);
        List<Long> ids = dish.getProductIds();
        ids.add(productId);
        dish.setProductIds(ids);
        dishRepository.save(dish);
    }
}
