package com.example.demo.Dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String nickname;
}
