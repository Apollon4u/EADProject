package com.example.actionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ActionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionMicroserviceApplication.class, args);
    }

}
