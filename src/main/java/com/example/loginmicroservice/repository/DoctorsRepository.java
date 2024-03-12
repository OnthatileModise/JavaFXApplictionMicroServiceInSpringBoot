package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.DoctorsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorsRepository extends CrudRepository<DoctorsModel , Long> {
    @Query(
            """
            SELECT
                dm
            FROM
                DoctorsModel dm
            """
    ) List<DoctorsModel> getAllDoctors();
}
