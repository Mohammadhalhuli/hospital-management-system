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
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "doctorName")
    private String doctorName;
    @Column(name = "doctorage")
    private String doctorage;
    @Column(name = "doctoraddress")
    private String doctoraddress;
    @Column(name = "doctorspecialization")
    private String doctorspecialization;
    @Column(name = "doctorsphone")
    private String doctorsphone;

}
