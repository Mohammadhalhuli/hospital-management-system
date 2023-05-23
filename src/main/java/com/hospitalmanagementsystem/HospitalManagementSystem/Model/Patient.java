package com.hospitalmanagementsystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "patientName")
    private String patientName;
    @Column(name = "patientage")
    private String patientage;
    @Column(name = "patientaddress")
    private String patientaddress;
    @Column(name = "patientGender")
    private String patientGender;
    @Column(name = "patientphone")
    private String patientphone;
    @Column(name = "patientIdDoctor")
    private int patientIdDoctor;
    @Column(name = "patientIdNurse")
    private int patientIdNurse;
    @Column(name = "patientIdRoomNumber")
    private int patientIdRoomNumber;
}
