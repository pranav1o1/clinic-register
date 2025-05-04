package com.clinic.clinic_register.service.impl;

import com.clinic.clinic_register.dto.AppointmentDTO;
import com.clinic.clinic_register.dto.AppointmentRegisterDTO;
import com.clinic.clinic_register.dto.PatientDetailsDTO;
import com.clinic.clinic_register.dto.AppointmentSummaryDTO;
import com.clinic.clinic_register.model.Appointment;
import com.clinic.clinic_register.model.Patient;
import com.clinic.clinic_register.repository.AppointmentRepository;
import com.clinic.clinic_register.repository.PatientRepository;
import com.clinic.clinic_register.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentRegisterDTO appointmentRegisterDTO) {
        Appointment appointment = new Appointment();

        Patient patient = patientRepository.findById(appointmentRegisterDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointment.setPatient(patient);

        appointment.setAppointmentDate(appointmentRegisterDTO.getAppointmentDate());
        appointment.setSymptoms(appointmentRegisterDTO.getSymptoms());
        appointment.setDiagnosis(appointmentRegisterDTO.getDiagnosis());
        appointment.setStatus(appointmentRegisterDTO.getStatus());
        appointment.setNotes(appointmentRegisterDTO.getNotes());
        Appointment saved = appointmentRepository.save(appointment);
        return mapToDTO(saved);
    }

    private AppointmentDTO mapToDTO(Appointment appointment) {
        Patient patient = appointment.getPatient();

        // Create PatientDetailsDTO
        PatientDetailsDTO patientDTO = new PatientDetailsDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFullName(patient.getFullName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        patientDTO.setReligion(patient.getReligion());
        patientDTO.setCity(patient.getCity());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        patientDTO.setBloodGroup(patient.getBloodGroup());
        patientDTO.setMedicalHistory(patient.getMedicalHistory());
        patientDTO.setReferredBy(patient.getReferredBy());

        // Now build AppointmentDTO
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatient(patientDTO); // **set the whole patientDTO**
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setSymptoms(appointment.getSymptoms());
        dto.setDiagnosis(appointment.getDiagnosis());
        dto.setStatus(appointment.getStatus());
        dto.setNotes(appointment.getNotes());

        return dto;
    }


    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Appointment not found"));
        return mapToDTO(appointment);

    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentSummaryDTO> getAppointmentsByPatientId(Long patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientIdOrderByAppointmentDateDesc(patientId);

        return appointments.stream()
                .map(a -> new AppointmentSummaryDTO(
                        a.getId(),
                        a.getPatient().getId(),
                        a.getAppointmentDate(),
                        a.getSymptoms(),
                        a.getDiagnosis(),
                        a.getStatus(),
                        a.getNotes()
                ))
                .collect(Collectors.toList());
    }


}
