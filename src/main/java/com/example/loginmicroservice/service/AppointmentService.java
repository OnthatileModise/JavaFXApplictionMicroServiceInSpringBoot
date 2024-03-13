package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.AppointmentModel;
import com.example.loginmicroservice.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentModel> getAllAppointments(){
        return appointmentRepository.getAllAppointments();
    }

    @Transactional
    @Modifying
    public void deleteAppointmentBYId(Long id){
        appointmentRepository.deleteById(id);
    }
}
