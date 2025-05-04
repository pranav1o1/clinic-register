package com.clinic.clinic_register.service;

import com.clinic.clinic_register.dto.PatientDetailsDTO;
import com.clinic.clinic_register.dto.PatientRegisterDTO;
import com.clinic.clinic_register.dto.PatientSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    PatientDetailsDTO createPatient(PatientRegisterDTO patientRegisterDTO);
    PatientDetailsDTO getPatientById(Long id);
    List<PatientDetailsDTO> getAllPatients();
    PatientDetailsDTO updatePatient(Long id, PatientRegisterDTO patientRegisterDTO);
    void deletePatient(Long id);

    List<PatientSummaryDTO> getAllPatientSummaries();

    List<PatientSummaryDTO> searchByField(String field, String value);
}
