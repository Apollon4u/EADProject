package com.example.usermicroservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "user-seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user-seq")
    private Long id;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column
    private String fio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "address")
    private String address;
}
