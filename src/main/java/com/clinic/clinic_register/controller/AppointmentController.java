package com.clinic.clinic_register.controller;

import com.clinic.clinic_register.dto.*;
import com.clinic.clinic_register.model.Appointment;
import com.clinic.clinic_register.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
//@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

     @Autowired
     private AppointmentService appointmentService;

     @PostMapping("/create")
     public ResponseEntity<AppointmentDTO> createAppointment(@Valid @RequestBody AppointmentRegisterDTO registerDTO) {
         AppointmentDTO appointment = appointmentService.createAppointment(registerDTO);
         return ResponseEntity.ok(appointment);
     }

     @GetMapping("/{id}")
     public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
         AppointmentDTO appointment = appointmentService.getAppointmentById(id);
         return ResponseEntity.ok(appointment);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
         appointmentService.deleteAppointment(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

    @GetMapping("/by-patient/{patientId}")
    public ResponseEntity<List<AppointmentSummaryDTO>> getAppointmentsByPatient(@PathVariable Long patientId) {
        List<AppointmentSummaryDTO> response = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(response);
    }

}
