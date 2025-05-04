package com.clinic.clinic_register.dto;

import jakarta.validation.constraints.*;

public class PrescribedMedicineRequestDTO {
    @NotBlank
    private String medicineName;

    @NotNull @Min(1)
    private Integer durationDays;

    @NotNull
    private Long instructionId;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public Long getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(Long instructionId) {
        this.instructionId = instructionId;
    }
}
