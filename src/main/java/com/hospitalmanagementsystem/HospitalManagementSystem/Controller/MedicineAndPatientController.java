package com.hospitalmanagementsystem.HospitalManagementSystem.Controller;

import com.hospitalmanagementsystem.HospitalManagementSystem.Model.Medicine;
import com.hospitalmanagementsystem.HospitalManagementSystem.Model.MedicineAndPatient;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.MedicineAndPatientRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.Repository.MedicineRepository;
import com.hospitalmanagementsystem.HospitalManagementSystem.excepation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/MedicineAndPatient")
public class MedicineAndPatientController {
    @Autowired
    private MedicineAndPatientRepository patientRepository;
    @GetMapping
    public List<MedicineAndPatient> getAllMedicineAndPatient(){
        return patientRepository.findAll();
    }
    //build creat MedicineAndPatient rest api
    @PostMapping
    public MedicineAndPatient createMedicineAndPatient(@RequestBody MedicineAndPatient medicine){
        return patientRepository.save(medicine);
    }
    //build get MedicineAndPatient by id rest api
    @GetMapping("{id}")
    public ResponseEntity<MedicineAndPatient> getMedicineAndPatient(@PathVariable int id){
        MedicineAndPatient medicineAndPatient =patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("MedicineAndPatient not exit with id:"+id)
        );
        return ResponseEntity.ok(medicineAndPatient);
    }
    //build update MedicineAndPatient rest api
    @PutMapping("{id}")
    public ResponseEntity<MedicineAndPatient> updateMedicineAndPatient(@PathVariable int id,@RequestBody MedicineAndPatient medicineAndPatient){
        MedicineAndPatient updatMedicineAndPatient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("MedicineAndPatient not exit with id:"+id));
        updatMedicineAndPatient.setIdMedicine(medicineAndPatient.getIdMedicine());
        updatMedicineAndPatient.setIdPatient(medicineAndPatient.getIdPatient());


        patientRepository.save(updatMedicineAndPatient);
        return ResponseEntity.ok(updatMedicineAndPatient);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMedicineAndPatient(@PathVariable int id){
        MedicineAndPatient MedicineAndPatient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("MedicineAndPatient not exit with id:"+id));
        patientRepository.delete(MedicineAndPatient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
