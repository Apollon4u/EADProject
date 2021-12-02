package com.example.authmicroservice.service;

import com.example.authmicroservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUsersFallback",
            threadPoolKey = "getUsers",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public List<User> getUsers() {
        List<User> users = restTemplate.getForObject("http://user-service/user",  List.class);
        return users;
    }

    public List<User> getUsersFallback() {
        return Collections.emptyList();
    }
}
