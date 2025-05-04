package com.clinic.clinic_register.dto;

public class MedicationInstructionDTO {
    private Long id;
    private String dosagePattern;
    private String mealTime;

    public MedicationInstructionDTO() {}

    public MedicationInstructionDTO(Long id, String dosagePattern, String mealTime) {
        this.id = id;
        this.dosagePattern = dosagePattern;
        this.mealTime = mealTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosagePattern() {
        return dosagePattern;
    }

    public void setDosagePattern(String dosagePattern) {
        this.dosagePattern = dosagePattern;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
}

