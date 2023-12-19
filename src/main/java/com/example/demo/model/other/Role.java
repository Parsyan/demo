package com.example.demo.model.other;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_SELLER,
    ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
