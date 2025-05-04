package com.clinic.clinic_register.dto;

public class PatientSummaryDTO {
    private Long id;
    private String fullName;
    private Integer age;
    private String gender;
    private String phoneNumber;

    public PatientSummaryDTO(){}

    public PatientSummaryDTO(Long id, String fullName,Integer age, String gender, String phoneNumber){
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
