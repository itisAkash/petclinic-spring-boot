package com.learning.petclinic.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.petclinic.petclinic.model.PetClinic;
import com.learning.petclinic.petclinic.service.PetClinicService;


@RestController
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @GetMapping("/all")
    public List<PetClinic> getAllPetClinicData() {
        return petClinicService.getAllPetClinicData();
    }
    
    @GetMapping("/pet/{petId}")
    public PetClinic getPetDataById(@PathVariable(name = "petId") Integer petId) {
        return petClinicService.getPetDataById(petId);
    }
    
}
