package com.example.loginmicroservice.controller;

import com.example.loginmicroservice.model.UserModel;
import com.example.loginmicroservice.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1")
public class RegisterController {
    private final RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registerUser") private ResponseEntity<UserModel> registerUser(@RequestBody UserModel userModel){
        try {
            return ResponseEntity.ok().body(registrationService.registerUserWithoutRole(userModel));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
