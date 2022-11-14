package com.example.Login.Project.api.service;

import com.example.Login.Project.dto.LoginDto;

public interface UserService {

    public Object userLogin(LoginDto loginDto);

    public Object userSignup(LoginDto loginDto);
}
