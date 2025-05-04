package com.clinic.clinic_register.service.impl;

import com.clinic.clinic_register.dto.MedicationInstructionDTO;
import com.clinic.clinic_register.model.MedicationInstruction;
import com.clinic.clinic_register.repository.MedicationInstructionRepository;
import com.clinic.clinic_register.service.MedicationInstructionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationInstructionServiceImpl implements MedicationInstructionService {

    private final MedicationInstructionRepository medicationInstructionRepository;

    public MedicationInstructionServiceImpl(MedicationInstructionRepository medicationInstructionRepository) {
        this.medicationInstructionRepository = medicationInstructionRepository;
    }

    @Override
    public List<MedicationInstructionDTO> getAllMedicationInstructions() {
        return medicationInstructionRepository.findAll()
                .stream()
                .map(instr -> new MedicationInstructionDTO(
                        instr.getId(),
                        instr.getDosagePattern(),
                        instr.getMealTime()
                ))
                .toList();
    }
}
