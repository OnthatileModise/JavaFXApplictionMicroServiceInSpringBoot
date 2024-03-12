package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.LoginModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginModel , Long> {
    @Query(
            """
            SELECT
                lm
            FROM
                LoginModel lm
            WHERE
                lm.name = ?1
            AND
                lm.password = ?2
            """
    )LoginModel performLogin(String username , String password);
}
