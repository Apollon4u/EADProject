package com.example.usermicroservice.converter;

import com.example.usermicroservice.model.dto.UserRegDto;
import com.example.usermicroservice.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegConverter implements Converter<UserRegDto, User> {
    @Override
    public User convert(UserRegDto source) {
        User user = new User();
        user.setEmail(source.getEmail());
        user.setFio(source.getFio());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setAddress(source.getAddress());
        user.setBankAccount(source.getBankAccount());
        return user;
    }
}
