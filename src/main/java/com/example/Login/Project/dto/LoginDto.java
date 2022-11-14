package com.example.Login.Project.dto;

import com.example.Login.Project.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Boolean isDeleted;

    public LoginDto(UserEntity savedEntity) {
        this.id = savedEntity.getId();
        this.name =savedEntity.getName();
        this.email = savedEntity.getEmail();
        this.password = savedEntity.getPassword();
        this.isDeleted =savedEntity.getIsDeleted();
    }
}
