package com.clinic.clinic_register.dto;

import com.clinic.clinic_register.model.AppointmentStatus;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private long id;
    private PatientDetailsDTO patient;
    private LocalDateTime appointmentDate;
    private String symptoms;
    private String diagnosis;
    private AppointmentStatus status;
    private String notes;

    public AppointmentDTO() {}

    public AppointmentDTO(long id, PatientDetailsDTO patient, LocalDateTime appointmentDate, String symptoms, String diagnosis, AppointmentStatus status, String notes){
        this.id = id;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.status = status;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PatientDetailsDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDetailsDTO patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
