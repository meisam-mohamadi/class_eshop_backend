package com.api.eshop.exceptions.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidLoginResponse {
    private String username;
    private String password;

    public InvalidLoginResponse() {
        username = "invalid username";
        password = "invalid password";
    }
}
