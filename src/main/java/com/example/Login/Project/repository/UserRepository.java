package com.example.Login.Project.repository;

import com.example.Login.Project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value ="select * from users where email= :mail", nativeQuery = true)
    UserEntity findByMail(@Param("mail")String mail);

}
