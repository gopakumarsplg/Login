package com.example.Login.Project.api.service.impl;

import com.example.Login.Project.api.service.UserService;
import com.example.Login.Project.dto.LoginDto;
import com.example.Login.Project.entity.UserEntity;
import com.example.Login.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Object userLogin(LoginDto loginDto) {
        try{
            UserEntity userEntity = userRepository.findByMail(loginDto.getEmail());
            if (userEntity.getIsDeleted()!= true){
                if (userEntity.getPassword().equals(loginDto.getPassword())){
                    return "Login Successful";
                }
            }
        }
        catch (Exception e){
            throw new RuntimeException("user not found");
        }
        return "Login Failed";
    }
}
