package com.hospitalmanagementsystem.HospitalManagementSystem.Repository;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepositoory extends JpaRepository<Nurse, Integer> {
}
