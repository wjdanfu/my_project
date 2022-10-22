package com.example.demo.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55, unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String encryptedPwd;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String userId;

    @Builder
    public User(long id, String email, String encryptedPwd, String name, String userId){
        this.email=email;
        this.id=id;
        this.name=name;
        this.userId=userId;
        this.encryptedPwd=encryptedPwd;
    }

}
