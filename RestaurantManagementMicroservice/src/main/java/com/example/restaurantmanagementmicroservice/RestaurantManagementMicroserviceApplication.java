package com.example.restaurantmanagementmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantManagementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementMicroserviceApplication.class, args);
    }

}
