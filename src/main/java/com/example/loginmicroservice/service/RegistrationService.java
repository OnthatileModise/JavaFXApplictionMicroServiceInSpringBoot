package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.UserModel;
import com.example.loginmicroservice.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public UserModel registerUserWithoutRole(UserModel userModel){
        return registrationRepository.save(userModel);
    }
}
