package com.hospitalmanagementsystem.HospitalManagementSystem.Repository;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
