package com.example.loginmicroservice.controller;

import com.example.loginmicroservice.model.AppointmentModel;
import com.example.loginmicroservice.service.AppointmentService;
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
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/getAllAppointments") public ResponseEntity<List<AppointmentModel>> getAllAppointments(){
        try{
            return ResponseEntity.ok().body(appointmentService.getAllAppointments());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deleteAppointment") public ResponseEntity<?> deleteAppointment(@RequestBody Map<? , ?> appointmentData){
        try {
            appointmentService.deleteAppointmentBYId(Long.valueOf(String.valueOf(appointmentData.get("id"))));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
