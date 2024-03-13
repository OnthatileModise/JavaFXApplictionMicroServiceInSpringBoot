package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<UserModel, Long> {
    @Query(
            """
            SELECT
                lm
            FROM
                UserModel lm
            WHERE
                lm.name = ?1
            AND
                lm.password = ?2
            """
    )UserModel performLogin(String username , String password);
}
