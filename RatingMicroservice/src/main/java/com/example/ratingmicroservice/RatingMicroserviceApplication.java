package com.example.ratingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingMicroserviceApplication.class, args);
    }

}
