package com.hospitalmanagementsystem.HospitalManagementSystem;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Doctor;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public void run(String... args) throws Exception {

	}
}
