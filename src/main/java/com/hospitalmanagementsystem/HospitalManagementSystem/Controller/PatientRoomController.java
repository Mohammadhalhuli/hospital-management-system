package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Patient;
import com.hospitalmanagementsystem.HospitalManagementSystem.Model.PatientRoom;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.PatientRoomRepositry;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/PatientRoom")
public class PatientRoomController {
    @Autowired
    private PatientRoomRepositry patientRoomRepositry;
    @GetMapping
    public List<PatientRoom> getAllPatientRoom(){
        return patientRoomRepositry.findAll();
    }
    //build creat PatientRoom rest api
    @PostMapping
    public PatientRoom createPatient(@RequestBody PatientRoom patientRoom){
        return patientRoomRepositry.save(patientRoom);
    }
    //build get PatientRoom by id rest api
    @GetMapping("{id}")
    public ResponseEntity<PatientRoom> getPatientRoomtId(@PathVariable int id){
        PatientRoom patientRoom =patientRoomRepositry.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id)
        );
        return ResponseEntity.ok(patientRoom);
    }
    //build update PatientRoom rest api
    @PutMapping("{id}")
    public ResponseEntity<PatientRoom> updatePatientRoom(@PathVariable int id,@RequestBody PatientRoom PatientRoomDetails){
        PatientRoom updatPatientRoom=patientRoomRepositry.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id));
        updatPatientRoom.setRoomName(PatientRoomDetails.getRoomName());
        updatPatientRoom.setTransferNo(PatientRoomDetails.getTransferNo());

        patientRoomRepositry.save(updatPatientRoom);
        return ResponseEntity.ok(updatPatientRoom);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatientRoom(@PathVariable int id){
        PatientRoom PatientRoom=patientRoomRepositry.findById(id).orElseThrow(()->
                new ResourceNotFoundException("v not exit with id:"+id));
        patientRoomRepositry.delete(PatientRoom);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
