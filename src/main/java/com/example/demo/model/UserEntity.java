package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Long으로 하는 이유 : 데이터가 많아질수록 숫자범위가 부족해질 수 있어서
    private Long id;

    private String password;

    private String email;

    private String nickname;

    private int money;

    private String Authority;

    //private List<BirdEntity> birdEntities;

    //private List<ItemEntity> itemEntities;


}
