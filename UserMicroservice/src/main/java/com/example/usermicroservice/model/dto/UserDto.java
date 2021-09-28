package com.example.usermicroservice.model.dto;

import com.example.usermicroservice.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String fio;
    private String phoneNumber;
    private String bankAccount;
    private String address;

    public static UserDto from(User user) {
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .fio(user.getFio())
                .phoneNumber(user.getPhoneNumber())
                .bankAccount(user.getBankAccount())
                .address(user.getAddress())
                .build();
    }
}
