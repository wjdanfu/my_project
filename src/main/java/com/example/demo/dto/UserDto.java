package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String name;
    private String password;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .userId(userId)
                .encryptedPwd(encryptedPwd)
                .build();
    }

    @Builder
    public UserDto(User entity){
        this.name = entity.getName();
        this.userId = entity.getUserId();
        this.email = entity.getEmail();
        this.encryptedPwd = entity.getEncryptedPwd();
    }
}
