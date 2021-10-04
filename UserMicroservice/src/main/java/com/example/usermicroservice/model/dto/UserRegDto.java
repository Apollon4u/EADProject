package com.example.usermicroservice.model.dto;

import lombok.Getter;

@Getter
public class UserRegDto {
    private String email;
    private String fio;
    private String phoneNumber;
    private String address;
    private String bankAccount;
}
