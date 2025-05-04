package com.clinic.clinic_register.dto;

public class PatientDetailsDTO {
    private Long id;
    private String fullName;
    private Integer age;
    private String gender;
    private String religion;
    private String city;
    private String phoneNumber;
    private String bloodGroup;
    private String medicalHistory;
    private String referredBy;

    // Constructors
    public PatientDetailsDTO() {}

    public PatientDetailsDTO(Long id, String fullName, Integer age, String gender, String religion,
                             String city, String phoneNumber, String bloodGroup,
                             String medicalHistory, String referredBy) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.religion = religion;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = medicalHistory;
        this.referredBy = referredBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }
}

