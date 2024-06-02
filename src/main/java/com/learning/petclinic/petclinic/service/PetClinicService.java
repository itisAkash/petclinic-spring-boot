package com.learning.petclinic.petclinic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.petclinic.petclinic.entity.PetClinic;

@Service
public class PetClinicService {
    @Autowired
    UserInfoUserDetailsService userDetailsService;
    
    public List<PetClinic> getAllPetClinicData() {
        List<PetClinic> petData = new ArrayList<>();
        PetClinic harris = PetClinic.builder()
                                    .id(1)
                                    .petName("Harris")
                                    .petOwnerName("prem")
                                    .petOwnerContactNumber("4444")
                                    .build();
        PetClinic peter = PetClinic.builder()
                                    .id(2)
                                    .petName("Peter")
                                    .petOwnerName("ratan")
                                    .petOwnerContactNumber("8888")
                                    .build();
        petData.add(harris);
        petData.add(peter);
        return petData;
    }

    public PetClinic getPetDataById(Integer petId) {
        return PetClinic.builder()
                        .id(petId)
                        .petName("Harris")
                        .petOwnerName("prem")
                        .petOwnerContactNumber("9999")
                        .build();
    }
}
