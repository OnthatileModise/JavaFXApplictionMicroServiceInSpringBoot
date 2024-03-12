package com.example.loginmicroservice.service;

import com.example.loginmicroservice.model.PatientsModel;
import com.example.loginmicroservice.repository.PatientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {
    private final PatientsRepository patientsRepository;

    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public List<PatientsModel> getAllPatients() {
        return patientsRepository.getAllPatients();
    }

    public List<PatientsModel> getActivePatients(){
        return patientsRepository.getActivePatients();
    }

    public PatientsModel updatePatientById(PatientsModel patientsModel) throws Exception {
        return patientsRepository.save(patientsModel);
    }

    @Transactional
    @Modifying
    public void deletePatient(Long patientId){
        patientsRepository.deleteById(patientId);
    }
}
