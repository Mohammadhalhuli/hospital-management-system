package com.hospitalmanagementsystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nurse")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nurseName")
    private String nurseName;
    @Column(name = "nurseage")
    private String nurseage;
    @Column(name = "nurseaddress")
    private String nurseaddress;
    @Column(name = "nursespecialization")
    private String nursespecialization;
    @Column(name = "nursephone")
    private String nursephone;

}
