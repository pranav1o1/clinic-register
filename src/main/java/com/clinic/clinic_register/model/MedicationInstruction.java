package com.clinic.clinic_register.model;

import jakarta.persistence.*;

@Entity
public class MedicationInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dosagePattern;
    private String mealTime;

    public MedicationInstruction(){}

    public MedicationInstruction(String dosagePattern, String mealTime) {
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
