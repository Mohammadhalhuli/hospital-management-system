package com.hospitalmanagementsystem.HospitalManagementSystem.Repository;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.MedicineAndPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineAndPatientRepository extends JpaRepository<MedicineAndPatient,Integer> {
}
