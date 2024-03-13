package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<UserModel , Long> {
}
