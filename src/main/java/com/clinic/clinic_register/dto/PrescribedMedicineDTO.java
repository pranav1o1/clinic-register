package com.clinic.clinic_register.dto;

public class PrescribedMedicineDTO {
    private Long id;
    private String medicineName;
    private Integer durationDays;
    private MedicationInstructionDTO instruction;

    public PrescribedMedicineDTO() {}

    public PrescribedMedicineDTO(Long id, String medicineName, Integer durationDays, MedicationInstructionDTO instruction) {
        this.id = id;
        this.medicineName = medicineName;
        this.durationDays = durationDays;
        this.instruction = instruction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public MedicationInstructionDTO getInstruction() {
        return instruction;
    }

    public void setInstruction(MedicationInstructionDTO instruction) {
        this.instruction = instruction;
    }
}

