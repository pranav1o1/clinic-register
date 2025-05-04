package com.clinic.clinic_register.dto;

import java.util.List;

public class PrescriptionSummaryDTO {
    private List<MedicineDTO> medicines;

    // Constructor, Getter, Setter
    public PrescriptionSummaryDTO() {}
    public PrescriptionSummaryDTO(List<MedicineDTO> medicines) {
        this.medicines = medicines;
    }

    public List<MedicineDTO> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineDTO> medicines) {
        this.medicines = medicines;
    }

    public static class MedicineDTO {
        private String medicineName;
        private Integer durationDays;
        private String dosagePattern;
        private String mealTime;

        // Constructor, Getters, Setters
        public MedicineDTO(){}

        public MedicineDTO(String medicineName, Integer durationDays, String dosagePattern, String mealTime) {
            this.medicineName = medicineName;
            this.durationDays = durationDays;
            this.dosagePattern = dosagePattern;
            this.mealTime = mealTime;
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
}

