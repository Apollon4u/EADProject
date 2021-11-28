package com.example.productmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableHystrix
public class ProductMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductMicroserviceApplication.class, args);
    }

    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        return new RestTemplate(requestFactory);
    }
}
