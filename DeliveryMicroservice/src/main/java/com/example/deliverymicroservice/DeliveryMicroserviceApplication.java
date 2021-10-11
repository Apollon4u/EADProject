package com.example.deliverymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeliveryMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryMicroserviceApplication.class, args);
    }

}
