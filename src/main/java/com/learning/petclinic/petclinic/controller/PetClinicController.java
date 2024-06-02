package com.learning.petclinic.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.petclinic.petclinic.entity.PetClinic;
import com.learning.petclinic.petclinic.entity.UserInfo;
import com.learning.petclinic.petclinic.repository.UserRepository;
import com.learning.petclinic.petclinic.service.PetClinicService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@RestController
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public List<PetClinic> getAllPetClinicData() {
        return petClinicService.getAllPetClinicData();
    }
    
    @GetMapping("/pet/{petId}")
    public PetClinic getPetDataById(@PathVariable(name = "petId") Integer petId) {
        return petClinicService.getPetDataById(petId);
    }

    @PostMapping("/pet/{petId}")
    public PetClinic createPetDataById(@PathVariable(name = "petId") Integer petId) {
        log.debug("Creating PetData for ID: {}", petId);
        return petClinicService.getPetDataById(petId);
    }

    @PostMapping("/add")
    public String postMethodName(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);
        return "User added to the system";
    }
}
