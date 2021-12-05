package com.example.usermicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "user-seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user-seq")
    private Long id;

    @ApiModelProperty("Почта")
    private String username;

    @ApiModelProperty("Пароль")
    private String password;

    @NotNull
    @ApiModelProperty("Почта")
    private String email;

    @ApiModelProperty("ФИО")
    private String fio;

    @Column(name = "phone_number")
    @ApiModelProperty("Номер телефона")
    private String phoneNumber;

    @Column(name = "bank_account")
    @ApiModelProperty("Банковский аккаунт")
    private String bankAccount;

    @ApiModelProperty("Адрес")
    private String address;

    private String role = "USER";
}
