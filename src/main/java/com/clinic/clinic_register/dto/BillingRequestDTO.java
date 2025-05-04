package com.clinic.clinic_register.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class BillingRequestDTO {
    @NotNull
    private Long appointmentId;

    @NotNull @DecimalMin("0.0")
    private BigDecimal amount;

    @NotNull
    private Boolean paid;

    @NotBlank
    private String paymentMethod;

    private String notes;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

