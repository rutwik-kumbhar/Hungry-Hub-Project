package com.example.paylode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthResponse {
    private  String token;
    private String message;
}
