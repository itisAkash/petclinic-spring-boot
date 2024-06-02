package com.learning.petclinic.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.petclinic.petclinic.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{

    UserInfo findByUsername(String username);
    
}
