package com.example.loginmicroservice.repository;

import com.example.loginmicroservice.model.AppointmentModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<AppointmentModel , Long> {
    @Query(
            """
            SELECT
                am
            FROM
                AppointmentModel am
            """
    ) List<AppointmentModel> getAllAppointments();
}
