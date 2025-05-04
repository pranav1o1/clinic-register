package com.clinic.clinic_register.repository;

import com.clinic.clinic_register.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT MAX(p.id) FROM Patient p")
    Long findMaxId();

    List<Patient> findByPhoneNumberContaining(String phone);
    List<Patient> findByFullNameContainingIgnoreCase(String name);
    List<Patient> findByCityContainingIgnoreCase(String city);
}

