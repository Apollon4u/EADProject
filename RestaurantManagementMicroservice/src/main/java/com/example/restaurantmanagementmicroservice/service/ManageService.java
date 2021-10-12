package com.example.restaurantmanagementmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ManageService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    public Double getDishPrice(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        ServiceInstance serviceInstance = loadBalancer.choose("kitchen-service");
        String baseUrl = serviceInstance.getUri().toString() + "/dishes/get-by-id";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Double> response = null;
        try {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, new HttpEntity<>(headers), Double.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return response.getBody();
    }

//    public void triggerOrder(Integer orderNumber) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject(
//                "http://localhost:8082/orders/make-order",
//                orderNumber,
//                Integer.class);
//    }
}
