package com.clinic.clinic_register.service.impl;

import com.clinic.clinic_register.dto.PrescribedMedicineRequestDTO;
import com.clinic.clinic_register.dto.PrescriptionCreateDTO;
import com.clinic.clinic_register.dto.PrescriptionSummaryDTO;
import com.clinic.clinic_register.exception.ResourceNotFoundException;
import com.clinic.clinic_register.model.Appointment;
import com.clinic.clinic_register.model.MedicationInstruction;
import com.clinic.clinic_register.model.PrescribedMedicine;
import com.clinic.clinic_register.model.Prescription;
import com.clinic.clinic_register.repository.AppointmentRepository;
import com.clinic.clinic_register.repository.MedicationInstructionRepository;
import com.clinic.clinic_register.repository.PrescribedMedicineRepository;
import com.clinic.clinic_register.repository.PrescriptionRepository;
import com.clinic.clinic_register.service.PrescriptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    private PrescriptionRepository prescriptionRepository;
    private MedicationInstructionRepository medicationInstructionRepository;
    private PrescribedMedicineRepository prescribedMedicineRepository;

    public PrescriptionServiceImpl(AppointmentRepository appointmentRepository,
                                    PrescriptionRepository prescriptionRepository,
                                    MedicationInstructionRepository medicationInstructionRepository,
                                    PrescribedMedicineRepository prescribedMedicineRepository) {
        this.appointmentRepository = appointmentRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicationInstructionRepository = medicationInstructionRepository;
        this.prescribedMedicineRepository = prescribedMedicineRepository;
    }

    @Override
    @Transactional
    public void createPrescription(PrescriptionCreateDTO createDTO) {
        Appointment appointment = appointmentRepository.findById(createDTO.getAppointmentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID"));

        Prescription prescription = new Prescription();
        prescription.setAppointment(appointment);
        prescriptionRepository.save(prescription);

        for(PrescribedMedicineRequestDTO medDTO : createDTO.getMedicine()) {
            MedicationInstruction instruction = medicationInstructionRepository.findById(medDTO.getInstructionId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid instruction ID"));

            PrescribedMedicine medicine = new PrescribedMedicine(
                    medDTO.getMedicineName(),
                    medDTO.getDurationDays(),
                    instruction,
                    prescription
            );
            prescribedMedicineRepository.save(medicine);
        }
    }

    @Override
    public PrescriptionSummaryDTO getPrescriptionSummaryByAppointmentId(Long appointmentId) {
        Prescription prescription = prescriptionRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));

        List<PrescriptionSummaryDTO.MedicineDTO> medicineDTOs = prescription.getPrescribedMedicines().stream()
                .map(med -> new PrescriptionSummaryDTO.MedicineDTO(
                        med.getMedicineName(),
                        med.getDurationDays(),
                        med.getInstruction().getDosagePattern(),
                        med.getInstruction().getMealTime()
                ))
                .collect(Collectors.toList());

        PrescriptionSummaryDTO dto = new PrescriptionSummaryDTO();
        dto.setMedicines(medicineDTOs);
        return dto;
    }

}
