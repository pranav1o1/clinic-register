package com.clinic.clinic_register.service;

import com.clinic.clinic_register.dto.AppointmentDTO;
import com.clinic.clinic_register.dto.AppointmentRegisterDTO;
import com.clinic.clinic_register.dto.AppointmentSummaryDTO;
import com.clinic.clinic_register.model.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentRegisterDTO appointmentRegisterDTO);
    AppointmentDTO getAppointmentById(Long id);
    void deleteAppointment(Long id);
    List<AppointmentSummaryDTO> getAppointmentsByPatientId(Long patientId);
}
