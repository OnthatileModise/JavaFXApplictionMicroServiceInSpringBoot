package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.DoctorsModel;
import com.example.loginmicroservice.repository.DoctorsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {
    private final DoctorsRepository doctorsRepository;

    public DoctorsService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    public List<DoctorsModel> getAllDoctors(){
        return doctorsRepository.getAllDoctors();
    }

    public DoctorsModel updateDoctor(DoctorsModel doctorsModel){
        return doctorsRepository.save(doctorsModel);
    }

    @Modifying
    @Transactional
    public void deleteDoctorById(Long id){
        doctorsRepository.deleteById(id);
    }
}
