package com.example.loginmicroservice.controller;

import com.example.loginmicroservice.model.LoginModel;
import com.example.loginmicroservice.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/performLogin") ResponseEntity<LoginModel> performLogin(
          @RequestBody Map<? , ?> loginData
    ){
        LoginModel loginModel = loginService.performLogin(String.valueOf(loginData.get("name")), String.valueOf(loginData.get("password")));
        if (loginModel == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok().body(loginModel);
        }
    }
}
