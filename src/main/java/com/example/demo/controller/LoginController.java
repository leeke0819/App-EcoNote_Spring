package com.example.demo.controller;

import com.example.demo.Dto.LoginRequestDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        boolean loginSuccess = userService.loginUser(loginRequestDto.getEmail(),loginRequestDto.getPassword());
        if (loginSuccess) {
            return "로그인 성공!";
        } else {
            return "잘못된 이메일 또는 비밀번호입니다.";
        }
    }
}
