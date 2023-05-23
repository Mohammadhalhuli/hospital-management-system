package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Medicine;
import com.hospitalmanagementsystem.HospitalManagementSystem.Model.PatientRoom;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.MedicineRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Medicine")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;
    @GetMapping
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }
    //build creat Medicine rest api
    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }
    //build get Medicine by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Medicine> getPatientMedicine(@PathVariable int id){
        Medicine Medicine =medicineRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Medicine not exit with id:"+id)
        );
        return ResponseEntity.ok(Medicine);
    }
    //build update Medicine rest api
    @PutMapping("{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable int id,@RequestBody Medicine MedicineRoomDetails){
        Medicine updatMedicine=medicineRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not exit with id:"+id));
        updatMedicine.setName(MedicineRoomDetails.getName());
        updatMedicine.setCount(MedicineRoomDetails.getCount());


        medicineRepository.save(updatMedicine);
        return ResponseEntity.ok(updatMedicine);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMedicine(@PathVariable int id){
        Medicine Medicine=medicineRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("v not exit with id:"+id));
        medicineRepository.delete(Medicine);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
