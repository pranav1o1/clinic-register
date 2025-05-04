package com.clinic.clinic_register.repository;

import com.clinic.clinic_register.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
