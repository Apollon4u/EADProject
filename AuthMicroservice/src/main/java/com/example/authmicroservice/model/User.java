package com.example.authmicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(value = "Данные юзера")
public class User {
    private Long id;
    @ApiModelProperty("Логин")
    private String username;
    @ApiModelProperty("Пароль")
    private String password;
    @ApiModelProperty("Почта")
    private String email;
    @ApiModelProperty("ФИО")
    private String fio;
    @ApiModelProperty("Номер телефона")
    private String phoneNumber;
    @ApiModelProperty("Банковский аккаунт")
    private String bankAccount;
    @ApiModelProperty("Адрес")
    private String address;
    @ApiModelProperty("Роль")
    private String role;
}
