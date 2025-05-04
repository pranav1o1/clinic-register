package com.clinic.clinic_register.repository;

import com.clinic.clinic_register.model.MedicationInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationInstructionRepository extends JpaRepository<MedicationInstruction, Long> {
}
