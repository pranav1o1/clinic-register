package com.clinic.clinic_register.dto;

import java.util.List;

public class PrescriptionDTO {
    private Long id;
    private Long appointmentId;
    private List<PrescribedMedicineDTO> prescribedMedicines;

    public PrescriptionDTO() {}

    public PrescriptionDTO(Long id, Long appointmentId, List<PrescribedMedicineDTO> prescribedMedicines) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.prescribedMedicines = prescribedMedicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public List<PrescribedMedicineDTO> getPrescribedMedicines() {
        return prescribedMedicines;
    }

    public void setPrescribedMedicines(List<PrescribedMedicineDTO> prescribedMedicines) {
        this.prescribedMedicines = prescribedMedicines;
    }
}

