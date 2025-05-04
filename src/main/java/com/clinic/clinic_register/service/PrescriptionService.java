package com.clinic.clinic_register.service;

import com.clinic.clinic_register.dto.PrescriptionCreateDTO;
import com.clinic.clinic_register.dto.PrescriptionSummaryDTO;

public interface PrescriptionService {
    void createPrescription(PrescriptionCreateDTO createDTO);
    //PrescriptionSummaryDTO getByAppointmentId(Long appointmentId);
    PrescriptionSummaryDTO getPrescriptionSummaryByAppointmentId(Long appointmentId);
}
