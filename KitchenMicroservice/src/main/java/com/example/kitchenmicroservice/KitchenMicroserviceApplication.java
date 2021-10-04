package com.example.kitchenmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KitchenMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KitchenMicroserviceApplication.class, args);
    }

}
