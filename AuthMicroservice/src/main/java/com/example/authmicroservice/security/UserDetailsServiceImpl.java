package com.example.authmicroservice.security;

import com.example.authmicroservice.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        List<com.example.authmicroservice.model.User> users = mapper.convertValue(
                userService.getUsers(),
                new TypeReference<>(){}
        );
        for (com.example.authmicroservice.model.User user: users) {
            if (user.getUsername().equals(username)) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());
                return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
        }
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
