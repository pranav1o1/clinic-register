package com.clinic.clinic_register.service.impl;

import com.clinic.clinic_register.dto.PatientDetailsDTO;
import com.clinic.clinic_register.dto.PatientRegisterDTO;
import com.clinic.clinic_register.dto.PatientSummaryDTO;
import com.clinic.clinic_register.model.Appointment;
import com.clinic.clinic_register.model.Patient;
import com.clinic.clinic_register.repository.AppointmentRepository;
import com.clinic.clinic_register.repository.PatientRepository;
import com.clinic.clinic_register.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public PatientDetailsDTO createPatient(PatientRegisterDTO patientRegisterDTO) {
        Patient patient = new Patient();
        patient.setFullName(patientRegisterDTO.getFullName());
        patient.setAge(patientRegisterDTO.getAge());
        patient.setGender(patientRegisterDTO.getGender());
        patient.setReligion(patientRegisterDTO.getReligion());
        patient.setCity(patientRegisterDTO.getCity());
        patient.setPhoneNumber(patientRegisterDTO.getPhoneNumber());
        patient.setBloodGroup(patientRegisterDTO.getBloodGroup());
        patient.setMedicalHistory(patientRegisterDTO.getMedicalHistory());
        patient.setReferredBy(patientRegisterDTO.getReferredBy());

        Patient saved = patientRepository.save(patient);
        return mapToDTO(saved);
    }

    private PatientDetailsDTO mapToDTO(Patient patient) {
        return new PatientDetailsDTO(
                patient.getId(),
                patient.getFullName(),
                patient.getAge(),
                patient.getGender(),
                patient.getReligion(),
                patient.getCity(),
                patient.getPhoneNumber(),
                patient.getBloodGroup(),
                patient.getMedicalHistory(),
                patient.getReferredBy()
        );
    }

    @Override
    public PatientDetailsDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient not found"));
        return mapToDTO(patient);
    }

    @Override
    public List<PatientDetailsDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public PatientDetailsDTO updatePatient(Long id, PatientRegisterDTO patientRegisterDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setFullName(patientRegisterDTO.getFullName());
        patient.setAge(patientRegisterDTO.getAge());
        patient.setGender(patientRegisterDTO.getGender());
        patient.setReligion(patientRegisterDTO.getReligion());
        patient.setCity(patientRegisterDTO.getCity());
        patient.setPhoneNumber(patientRegisterDTO.getPhoneNumber());
        patient.setBloodGroup(patientRegisterDTO.getBloodGroup());
        patient.setMedicalHistory(patientRegisterDTO.getMedicalHistory());
        patient.setReferredBy(patientRegisterDTO.getReferredBy());

        Patient updated = patientRepository.save(patient);
        return mapToDTO(updated);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientSummaryDTO> getAllPatientSummaries(){
        return patientRepository.findAll().stream()
                .map(p -> new PatientSummaryDTO(
                        p.getId(),
                        p.getFullName(),
                        p.getAge(),
                        p.getGender(),
                        p.getPhoneNumber()
                ))
                .toList();
    }

    @Override
    public List<PatientSummaryDTO> searchByField(String field, String value) {
        List<Patient> patients;

        switch (field.toLowerCase()) {
            case "phone":
                patients = patientRepository.findByPhoneNumberContaining(value);
                break;
            case "name":
                patients = patientRepository.findByFullNameContainingIgnoreCase(value);
                break;
            case "city":
                patients = patientRepository.findByCityContainingIgnoreCase(value);
                break;
            case "symptom":
                patients = appointmentRepository.findBySymptomsContainingIgnoreCase(value)
                        .stream()
                        .map(Appointment::getPatient)
                        .distinct()
                        .toList();
                break;
            case "diagnosis":
                patients = appointmentRepository.findByDiagnosisContainingIgnoreCase(value)
                        .stream()
                        .map(Appointment::getPatient)
                        .distinct()
                        .toList();
                break;
            default:
                patients = List.of();
        }

        return patients.stream().map(p -> new PatientSummaryDTO(
                p.getId(),
                p.getFullName(),
                p.getAge(),
                p.getGender(),
                p.getPhoneNumber()
        )).toList();
    }

}
