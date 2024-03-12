package com.example.loginmicroservice.controller;

import com.example.loginmicroservice.model.PatientsModel;
import com.example.loginmicroservice.service.PatientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1")
public class PatientsController {
    private final PatientsService patientsService;

    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping("/getAllPatients") ResponseEntity<List<PatientsModel>> getAllPatients(){
        List<PatientsModel> patientsModel = patientsService.getAllPatients();
        if (patientsModel.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok().body(patientsModel);
        }
    }

    @GetMapping("/getActivePatients") ResponseEntity<List<PatientsModel>> getActivePatients(){
        try{
            return ResponseEntity.ok().body(patientsService.getActivePatients());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatePatient")
    public ResponseEntity<PatientsModel> updatePatient(@RequestBody PatientsModel patientsModel){
        try {
            return ResponseEntity.ok().body(patientsService.updatePatientById(patientsModel));
        }catch (Exception e){
            System.out.println("error updating patient" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deletePatient") private void deletePatient(@RequestBody Map<? , ?> patientData){
        patientsService.deletePatient(Long.valueOf(String.valueOf(patientData.get("id"))));
    }
}
