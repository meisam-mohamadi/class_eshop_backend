package com.api.eshop.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtLoginSuccessResponse
{
    private boolean success;
    private String token;

    public JwtLoginSuccessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtLoginSuccessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
