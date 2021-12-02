package com.example.authmicroservice.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtConfig {
    private String uri = "/auth/**";
    private String header = "Authorization";
    private String prefix = "Bearer ";
    private int expiration = 24 * 60 * 60;
    private String secret = "JwtSecretKey";
}
