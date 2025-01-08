package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public boolean existsByEmail(String email);

    public boolean existsByNickname(String nickname);
    UserEntity findByEmail(String email);
    UserEntity findByNickname(String nickname);
}