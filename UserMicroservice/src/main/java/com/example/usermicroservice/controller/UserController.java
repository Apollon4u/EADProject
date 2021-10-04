package com.example.usermicroservice.controller;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.dto.UserRegDto;
import com.example.usermicroservice.service.UserService;
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
    public ResponseEntity<UserDto> getUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @GetMapping("create")
    public void createUser(@RequestBody UserRegDto dto) {
        userService.createUser(dto);
    }

    @PostMapping("make-order")
    public void makeOrder(@RequestParam("number") Long userId,
                          @RequestParam("number") List<Long> dishIds) {
        userService.makeOrder(userId, dishIds);
    }
}
