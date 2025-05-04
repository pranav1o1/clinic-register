package com.clinic.clinic_register.controller;

import com.clinic.clinic_register.dto.PrescriptionCreateDTO;
import com.clinic.clinic_register.dto.PrescriptionSummaryDTO;
import com.clinic.clinic_register.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/create")
    public ResponseEntity<String> createPrescription(@Valid @RequestBody PrescriptionCreateDTO createDTO) {
        prescriptionService.createPrescription(createDTO);
        return ResponseEntity.ok("Prescription created successfully");
    }

    @GetMapping("/summary/{appointmentId}")
    public ResponseEntity<PrescriptionSummaryDTO> getSummary(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionSummaryByAppointmentId(appointmentId));
    }

}
