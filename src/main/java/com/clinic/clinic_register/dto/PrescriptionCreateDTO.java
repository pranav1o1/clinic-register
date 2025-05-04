package com.clinic.clinic_register.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PrescriptionCreateDTO {
    @NotNull
    private Long appointmentId;

    @NotEmpty
    private List<PrescribedMedicineRequestDTO> medicine;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public List<PrescribedMedicineRequestDTO> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<PrescribedMedicineRequestDTO> medicine) {
        this.medicine = medicine;
    }
}
