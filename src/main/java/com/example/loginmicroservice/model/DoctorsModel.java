package com.example.loginmicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DOCTORS")
@Getter
@Setter
public class DoctorsModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID") private Long id;
    @Column(name = "NAME") private String name;
    @Column(name = "GENDER") private String gender;
    @Column(name = "CONTACT_NUMBER") private String contactNumber;
    @Column(name = "EMAIL_ADDRESS") private String emailAddress;
    @Column(name = "SPECIALIZATION") private String specialization;
    @Column(name = "ADDRESS") private String address;
    @Column(name ="STATUS") private String status;
}
