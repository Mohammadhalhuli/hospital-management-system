package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Doctor;
import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Nurse;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.DoctorRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.NurseRepositoory;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Nurse")
public class NurseCntroler {
    @Autowired
    private NurseRepositoory nurseRepositoory;
    @GetMapping
    public List<Nurse> getAllNurse(){
        return nurseRepositoory.findAll();
    }
    //build creat Nurse rest api
    @PostMapping
    public Nurse createNurse(@RequestBody Nurse nurse){
        return nurseRepositoory.save(nurse);
    }
    //build get Nurse by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Nurse> getNurseId(@PathVariable int id){
        Nurse nurse  =nurseRepositoory.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Nurse not exit with id:"+id)
        );
        return ResponseEntity.ok(nurse);
    }
    //build update Nurse rest api
    @PutMapping("{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable int id,@RequestBody Nurse nurseDetails){
        Nurse updatNurse=nurseRepositoory.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Nurse not exit with id:"+id));
        updatNurse.setNurseName(nurseDetails.getNurseName());
        updatNurse.setNurseage(nurseDetails.getNurseage());
        updatNurse.setNurseaddress(nurseDetails.getNurseaddress());
        updatNurse.setNursephone(nurseDetails.getNursephone());
        updatNurse.setNursespecialization(nurseDetails.getNursespecialization());



        nurseRepositoory.save(updatNurse);
        return ResponseEntity.ok(updatNurse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNurse(@PathVariable int id){
        Nurse nurse=nurseRepositoory.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Nurse not exit with id:"+id));
        nurseRepositoory.delete(nurse);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
