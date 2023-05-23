package com.hospitalmanagementsystem.HospitalManagementSystem.Repository;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.PatientRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRoomRepositry extends JpaRepository<PatientRoom,Integer> {
}
