package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Doctor;
import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Patient;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.DoctorRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.PatientRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
    //build creat Patient rest api
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
    //build get Patient by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientId(@PathVariable int id){
        Patient patient =patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id)
        );
        return ResponseEntity.ok(patient);
    }
    //build update Patient rest api
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient PatientDetails){
        Patient updatPatient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id));
        updatPatient.setPatientName(PatientDetails.getPatientName());
        updatPatient.setPatientGender(PatientDetails.getPatientGender());
        updatPatient.setPatientaddress(PatientDetails.getPatientaddress());
        updatPatient.setPatientage(PatientDetails.getPatientage());
        updatPatient.setPatientphone(PatientDetails.getPatientphone());
        updatPatient.setPatientIdDoctor(PatientDetails.getPatientIdDoctor());
        updatPatient.setPatientIdNurse(PatientDetails.getPatientIdNurse());
        updatPatient.setPatientIdRoomNumber(PatientDetails.getPatientIdRoomNumber());
        patientRepository.save(updatPatient);
        return ResponseEntity.ok(updatPatient);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable int id){
        Patient patient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id));
        patientRepository.delete(patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
