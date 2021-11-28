package com.example.usermicroservice.controller;

import com.example.usermicroservice.model.User;
import com.example.usermicroservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Api(value = "Методы для работы с юзерами")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить юзера по его айди")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    @ApiOperation(value = "Создать юзера")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("get-email")
    @ApiOperation(value = "Получить почту юзера")
    public String getUserId(@RequestParam("id") Long id) {
        return userService.getUser(id).getEmail();
    }

    @GetMapping
    @ApiOperation(value = "Получить всех юзеров")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
