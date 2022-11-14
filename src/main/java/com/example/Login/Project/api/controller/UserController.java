package com.example.Login.Project.api.controller;

import com.example.Login.Project.api.service.impl.UserServiceImpl;
import com.example.Login.Project.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Object userSignup(LoginDto loginDto){
        LoginDto loginDto1 = userService.userSignup(loginDto);
        return loginDto1;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object userLogin(@RequestBody LoginDto loginDto, HttpServletRequest request){
        return userService.userLogin(loginDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "hello";
    }
}
