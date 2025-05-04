package com.clinic.clinic_register.repository;

import com.clinic.clinic_register.model.PrescribedMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescribedMedicineRepository extends JpaRepository<PrescribedMedicine, Long> {
}
