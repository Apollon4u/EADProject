package com.example.usermicroservice.model.dto;

import com.example.usermicroservice.model.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;
    private String fio;
    private String phoneNumber;
    private String bankAccount;
    private String address;

    public static UserDto from(User user) {
        return builder()
                .email(user.getEmail())
                .fio(user.getFio())
                .phoneNumber(user.getPhoneNumber())
                .bankAccount(user.getBankAccount())
                .address(user.getAddress())
                .build();
    }
}
