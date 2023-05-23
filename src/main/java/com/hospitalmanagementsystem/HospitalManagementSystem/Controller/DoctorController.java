package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Doctor;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.DoctorRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
    //build creat Doctor rest api
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }
    //build get Doctor by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorId(@PathVariable int id){
        Doctor doctor =doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor not exit with id:"+id)
        );
        return ResponseEntity.ok(doctor);
    }
    //build update Doctor rest api
    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id,@RequestBody Doctor doctorDetails){
        Doctor updatdoctoor=doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor not exit with id:"+id));
        updatdoctoor.setDoctorName(doctorDetails.getDoctorName());
        updatdoctoor.setDoctorage(doctorDetails.getDoctorage());
        updatdoctoor.setDoctoraddress(doctorDetails.getDoctoraddress());
        updatdoctoor.setDoctorsphone(doctorDetails.getDoctorsphone());
        updatdoctoor.setDoctorspecialization(doctorDetails.getDoctorspecialization());


        doctorRepository.save(updatdoctoor);
        return ResponseEntity.ok(updatdoctoor);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable int id){
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor not exit with id:"+id));
        doctorRepository.delete(doctor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
