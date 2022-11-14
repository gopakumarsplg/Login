package com.example.Login.Project.dto;

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
}
