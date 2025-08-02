package com.example.demo.security;

import lombok.Data;


public class JwtAuthResponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

}
