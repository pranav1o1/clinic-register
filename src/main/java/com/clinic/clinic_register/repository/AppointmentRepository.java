package com.clinic.clinic_register.repository;

import com.clinic.clinic_register.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientIdOrderByAppointmentDateDesc(Long patientId);
    List<Appointment> findBySymptomsContainingIgnoreCase(String symptom);
    List<Appointment> findByDiagnosisContainingIgnoreCase(String diagnosis);
}

