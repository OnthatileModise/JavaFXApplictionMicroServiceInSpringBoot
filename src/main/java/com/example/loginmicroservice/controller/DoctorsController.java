package com.example.loginmicroservice.controller;

import com.example.loginmicroservice.model.DoctorsModel;
import com.example.loginmicroservice.service.DoctorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1")
public class DoctorsController {
    private final DoctorsService doctorsService;

    public DoctorsController(DoctorsService doctorsService) {
        this.doctorsService = doctorsService;
    }

    @GetMapping("/getAllDoctors") private ResponseEntity<List<DoctorsModel>> getAllDoctors (){
        try {
            return ResponseEntity.ok().body(doctorsService.getAllDoctors());
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateDoctor") private ResponseEntity<DoctorsModel> updateDoctor(@RequestBody DoctorsModel doctorsModel){
        try {
            return ResponseEntity.ok().body(doctorsService.updateDoctor(doctorsModel));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deleteDoctor") private void deleteDoctor(@RequestBody Map<? , ?> doctorData){
        try {
            doctorsService.deleteDoctorById(Long.valueOf(String.valueOf(doctorData.get("id"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/getDoctorsBySpecialization") private ResponseEntity<List<DoctorsModel>> getDoctorsModelBySpecialization(
            @RequestBody Map<? , ?> specialization
    ){
       List<DoctorsModel> doctorsModels = doctorsService.getDoctorsModelBySpecialization(String.valueOf(specialization.get("specialization")));
       if (doctorsModels.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }else {
           return ResponseEntity.ok().body(doctorsModels);
       }
    }
}
