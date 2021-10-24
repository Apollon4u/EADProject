package com.example.usermicroservice.controller;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.dto.UserRegDto;
import com.example.usermicroservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("get-by-id")
    @ApiOperation(value = "Получить юзера по его айди")
    public ResponseEntity<UserDto> getUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @GetMapping("create")
    @ApiOperation(value = "Создать юзера")
    public void createUser(@RequestBody UserRegDto dto) {
        userService.createUser(dto);
    }

    @PostMapping("make-order")
    @ApiOperation(value = "Создание заказа для юзера")
    public void makeOrder(@RequestParam("number") Long userId,
                          @RequestParam("number") List<Long> dishIds) {
        userService.makeOrder(userId, dishIds);
    }
}
