package com.example.usermicroservice.controller;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class UserController {

    private final IUserService userService;

    @GetMapping("get-by-id")
    public ResponseEntity<UserDto> getUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("make-order")
    public void makeOrder(@RequestParam("number") Integer number) {
        userService.makeOrder(number);
    }
}
