package com.example.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableHystrixDashboard
//@EnableHystrix
public class OrderMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMicroserviceApplication.class, args);
    }

    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        return new RestTemplate(requestFactory);
    }
}
