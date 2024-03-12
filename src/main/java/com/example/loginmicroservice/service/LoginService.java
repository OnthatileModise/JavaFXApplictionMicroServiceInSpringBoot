package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.LoginModel;
import com.example.loginmicroservice.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel performLogin(String username, String password) throws NullPointerException {
        return loginRepository.performLogin(username, password);
    }
}
