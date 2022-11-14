package com.example.Login.Project.api.service.impl;

import com.example.Login.Project.api.service.UserService;
import com.example.Login.Project.dto.LoginDto;
import com.example.Login.Project.entity.UserEntity;
import com.example.Login.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Object userLogin(LoginDto loginDto) {
        try{
            UserEntity userEntity = userRepository.findByMail(loginDto.getEmail());
//            if (userEntity.getIsDeleted()!= true){
                if (userEntity.getPassword()==(loginDto.getPassword())){
                    return "Login Successful";
//                }
            }
        }
        catch (Exception e){
            throw new RuntimeException("user not found");
        }
        return "Login Failed";
    }

    @Override
    public LoginDto userSignup(LoginDto loginDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(loginDto.getId());
        userEntity.setName(loginDto.getName());
        userEntity.setEmail(loginDto.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(passwordEncoder.encode(loginDto.getPassword()));
        UserEntity savedEntity = userRepository.save(userEntity);
        return new LoginDto(savedEntity);
    }
}
