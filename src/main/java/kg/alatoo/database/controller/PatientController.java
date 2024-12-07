package kg.alatoo.database.controller;

import kg.alatoo.database.dto.patient.MedicalHistoryDTO;
import kg.alatoo.database.entity.Appointment;
import kg.alatoo.database.entity.Patient;
import kg.alatoo.database.enums.Status;
import kg.alatoo.database.service.AppointmentService;
import kg.alatoo.database.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    @GetMapping("/history/{patientId}")
    public String viewMedicalHistory(@PathVariable Long patientId, Model model) {
        MedicalHistoryDTO medicalHistory = patientService.getMedicalHistory(patientId);
        model.addAttribute("medicalHistory", medicalHistory);
        return "patientHistory";
    }
    @GetMapping("/appointments/{patientId}")
    public String viewAppointments(@PathVariable Long patientId, Model model) {
        var appointments = patientService.getAppointments(patientId);
        model.addAttribute("appointments", appointments);
        return "appointments-patient";
    }
    @GetMapping("/appointments/book/{patientId}")
    public String bookAppointment(@PathVariable Long patientId, Model model) {
        var availableDoctors = patientService.getAvailableDoctors();
        model.addAttribute("availableDoctors", availableDoctors);
        return "bookAppointment";
    }
    @PostMapping("/book/{patientId}")
    public String saveAppointment(@PathVariable Long patientId, Appointment appointment) {
        Patient patient = patientService.getPatientById(patientId);
        appointment.setPatient(patient);
        appointment.setStatus(Status.PENDING);

        appointmentService.saveAppointment(appointment);

        return "redirect:/appointments";
    }
    @GetMapping("/appointments/cancel/{appointmentId}")
    public String cancelAppointment(@PathVariable Long appointmentId, Model model) {
        patientService.cancelAppointment(appointmentId);
        model.addAttribute("message", "Appointment canceled successfully!");
        return "redirect:/appointments-patient";
    }

}
