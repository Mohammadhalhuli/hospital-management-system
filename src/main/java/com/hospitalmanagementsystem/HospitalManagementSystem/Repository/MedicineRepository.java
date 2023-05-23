package com.hospitalmanagementsystem.HospitalManagementSystem.Repository;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
}
