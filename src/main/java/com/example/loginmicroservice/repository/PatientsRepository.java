package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.PatientsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientsRepository extends CrudRepository<PatientsModel, Long> {
    @Query(
            """
            SELECT
                pm
            FROM
                PatientsModel  pm
            """
    ) List<PatientsModel> getAllPatients();

    @Query(
            """
             SELECT
                pm
            FROM
                PatientsModel  pm
            WHERE
                pm.status LIKE '%ACTIVE%'
            """
    )List<PatientsModel> getActivePatients();
}
