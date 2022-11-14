package com.example.Login.Project.api.controller;

import com.example.Login.Project.api.service.impl.UserServiceImpl;
import com.example.Login.Project.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public Object userLogin(LoginDto loginDto, HttpServletRequest request){
        return userService.userLogin(loginDto);
    }
}
