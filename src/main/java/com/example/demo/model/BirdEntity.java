package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BirdEntity {
    @Id
    private int id;
    private String name;
    private int age;
    private int health;
    private int thirst;
    private int hungry;
    //private int favorability;
    private int level;
}
