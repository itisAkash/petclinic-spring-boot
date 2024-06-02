package com.learning.petclinic.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.petclinic.petclinic.entity.UserInfo;
import com.learning.petclinic.petclinic.model.UserInfoDetails;
import com.learning.petclinic.petclinic.repository.UserRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserInfo user = userRepository.findByUsername(username);
       if(user == null){
            throw new UsernameNotFoundException("User not found");
       }
       System.out.println("USER_DETAILS: " + user.toString());
       return new UserInfoDetails(user);
    }

}
