package com.example.usermicroservice.service.impl;

import com.example.usermicroservice.converter.UserRegConverter;
import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.dto.UserRegDto;
import com.example.usermicroservice.model.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.example.usermicroservice.service.UserService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRegConverter userRegConverter;
    private RestTemplate restTemplate;

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.from(user);
    }

//    @HystrixCommand(
//            fallbackMethod = "getUserByIdFallback",
//            threadPoolKey = "getUserById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            })
//    public UserDto getUserById(Long id) {
//        return restTemplate.getForObject("http://user-service/user/get-by-id" + id, UserDto.class);
//    }

    @HystrixCommand(
            fallbackMethod = "getUserByIdFallback",
            threadPoolKey = "getUserById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            },
            commandKey = "getOrderById",
            commandProperties = {
                    @HystrixProperty(name = "requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "errorThresholdPercentage", value = "75"),
                    @HystrixProperty(name = "sleepWindowInMilliseconds", value = "7000")
            }
            )
    public UserDto getUserById(Long id) {
        return restTemplate.getForObject("http://user-service/user/get-by-id" + id, UserDto.class);
    }

    public UserDto getUserByIdFallback(Long id) {
        UserDto user = new UserDto();
        user.setAddress("Address is not available: Service Unavailable");
        user.setFio("FIO is not available: Service Unavailable");
        user.setEmail("Email is not available: Service Unavailable");
        user.setPhoneNumber("Number is not available: Service Unavailable");
        user.setBankAccount("Account is not available: Service Unavailable");
        return user;
    }

    @Override
    public void createUser(UserRegDto dto) {
        userRepository.save(userRegConverter.convert(dto));
    }

    @Override
    public void makeOrder(Long userId, List<Long> dishIds) {

    }
}
