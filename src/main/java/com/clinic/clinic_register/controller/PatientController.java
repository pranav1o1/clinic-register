package com.clinic.clinic_register.controller;

import com.clinic.clinic_register.dto.PatientDetailsDTO;
import com.clinic.clinic_register.dto.PatientRegisterDTO;
import com.clinic.clinic_register.dto.PatientSummaryDTO;
import com.clinic.clinic_register.repository.PatientRepository;
import com.clinic.clinic_register.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/create")
    public ResponseEntity<PatientDetailsDTO> createPatient(@Valid @RequestBody PatientRegisterDTO requestDTO) {
        PatientDetailsDTO response = patientService.createPatient(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/patientDetail/{patientId}")
    public ResponseEntity<PatientDetailsDTO> getPatientById(@PathVariable Long patientId){
        PatientDetailsDTO patient = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/allPatient")
    public ResponseEntity<List<PatientSummaryDTO>> getAllPatients(){
        List<PatientSummaryDTO> response = patientService.getAllPatientSummaries();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDetailsDTO> updatePatient(
            @PathVariable Long id, @Valid @RequestBody PatientRegisterDTO requestDTO) {
        PatientDetailsDTO response = patientService.updatePatient(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/next-id")
    public ResponseEntity<Map<String,Long>> getNextPatientId() {
        Long maxId = patientRepository.findMaxId();
        Long nextId = (maxId != null) ? maxId + 1 : 1;
        return ResponseEntity.ok(Map.of("nextId", nextId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientSummaryDTO>> searchPatients(
            @RequestParam String field,
            @RequestParam String value) {
        System.out.println("Received search: field=" + field + ", value=" + value);
        return ResponseEntity.ok(patientService.searchByField(field, value));
    }

}

