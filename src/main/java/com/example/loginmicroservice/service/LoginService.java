package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.UserModel;
import com.example.loginmicroservice.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public UserModel performLogin(String username, String password) throws NullPointerException {
        return loginRepository.performLogin(username, password);
    }
}
