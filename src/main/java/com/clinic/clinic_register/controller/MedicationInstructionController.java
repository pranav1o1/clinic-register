package com.clinic.clinic_register.controller;

import com.clinic.clinic_register.dto.MedicationInstructionDTO;
import com.clinic.clinic_register.service.MedicationInstructionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instructions")
public class MedicationInstructionController {
    private final MedicationInstructionService medicationInstructionService;

    public MedicationInstructionController(MedicationInstructionService medicationInstructionService) {
        this.medicationInstructionService = medicationInstructionService;
    }

    @GetMapping
    public List<MedicationInstructionDTO> getAllMedicationInstructions() {
        return medicationInstructionService.getAllMedicationInstructions();
    }
}
