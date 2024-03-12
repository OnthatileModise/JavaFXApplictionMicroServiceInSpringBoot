package com.example.loginmicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "APPOINTMENTS")
@Getter
@Setter
public class AppointmentModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID") private Long id;
    @Column(name = "NAME") private String name;
    @Column(name = "GENDER") private String gender;
    @Column(name = "CONTACT") private String contact;
    @Column(name = "DESCRIPTION") private String description;
    @Column(name = "DATE") private LocalDate date;
    @Column(name = "DATE_MODIFIED") private LocalDate dateModified;
    @Column(name = "DATE_DELETED") private LocalDate dateDeleted;
    @Column(name = "STATUS") private String status;
}
