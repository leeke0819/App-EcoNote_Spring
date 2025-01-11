package com.example.demo.service;

import com.example.demo.Dto.TokenDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final TokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    public UserService(AuthenticationManagerBuilder managerBuilder, TokenProvider tokenProvider) {
        this.managerBuilder = managerBuilder;
        this.tokenProvider = tokenProvider;
    }

    public UserEntity saveUser(String email, String password, String nickname) {

        if (userRepository.existsByEmail(email)) {
            throw new EntityExistsException("이미 존재하는 이메일입니다.");
        }
        if (userRepository.existsByNickname(nickname)) {
            throw new EntityExistsException("이미 존재하는 닉네임입니다.");
        }

        if (password.length() < 8 || password.length() > 12) {
            throw new IllegalArgumentException("비밀번호는 8자 이상, 12자 이하로 설정해야 합니다.");
        }

        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {
            throw new IllegalArgumentException("비밀번호는 대문자, 소문자, 숫자를 최소 하나씩 포함해야 합니다.");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setNickname(nickname);
        userEntity.setMoney(10000);
        userRepository.save(userEntity);
        return userEntity;
    }

    public TokenDto loginUser(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity.getPassword().equals(password)) {
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(email, password);
            Authentication authentication
                    = managerBuilder.getObject().authenticate(authenticationToken);
            return tokenProvider.generateTokenDto(authentication);
        }
        return null;
    }
}
