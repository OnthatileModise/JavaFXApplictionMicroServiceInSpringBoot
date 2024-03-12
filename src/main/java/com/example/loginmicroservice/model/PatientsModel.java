package com.example.loginmicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "PATIENTS")
@Getter
@Setter
public class PatientsModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false) @JdbcTypeCode(SqlTypes.BIGINT) private Long id;
    @Column(name = "NAME") private String name;
    @Column(name = "SURNAME") private String surname;
    @Column(name = "CELLPHONE_NUMBER") private String cellPhoneNumber;
    @Column(name = "TEL_PHONE_NUMBER") private String telPhoneNumber;
    @Column(name = "ADDRESS") private String address;
    @Column(name = "APPOINTMENT_ID") private Long appointmentId;
    @Column(name = "GENDER") private String gender;
    @Column(name = "DESCRIPTION") private String description;
    @Column(name = "STATUS") private String status;
    @Column(name = "DATE") private LocalDate date;
    @Column(name = "DATE_MODIFIED") private LocalDate dateModified;
    @Column(name = "DATE_DELETED") private LocalDate dateDeleted;
}
