package com.clinic.clinic_register.model;


import jakarta.persistence.*;

@Entity
@Table(name = "prescribed_medicines")
public class PrescribedMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;   // Name of the medicine

    private Integer durationDays;  // Duration for taking the medicine

    @ManyToOne
    @JoinColumn(name = "instruction_id", nullable = false)  // Foreign key to MedicationInstruction
    private MedicationInstruction instruction;

    @ManyToOne
    @JoinColumn(name = "prescription_id", nullable = false) // Foreign key to Prescription
    private Prescription prescription;

    // Default constructor
    public PrescribedMedicine() {
    }

    // Constructor with parameters
    public PrescribedMedicine(String medicineName, Integer durationDays, MedicationInstruction instruction, Prescription prescription) {
        this.medicineName = medicineName;
        this.durationDays = durationDays;
        this.instruction = instruction;
        this.prescription = prescription;
    }

    // Getters and setters
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

    public MedicationInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(MedicationInstruction instruction) {
        this.instruction = instruction;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}

