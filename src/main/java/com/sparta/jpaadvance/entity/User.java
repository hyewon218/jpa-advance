package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "user")
    private Food food;

    public void addFood(Food food) {
        this.food = food;
        // User 객체 자신을 실제 외래키의 주인에게 주게 되는 것
        // 외래키 설정 (필드로 외래키의 주인을 받아오기 때문에 this 를 넘겨줌)
        food.setUser(this);
    }
}