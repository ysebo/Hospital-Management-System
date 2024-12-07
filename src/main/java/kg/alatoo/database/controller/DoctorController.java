package kg.alatoo.database.controller;

import kg.alatoo.database.service.DoctorService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public String viewAssignedPatients(Model model) {
        var patients = doctorService.getAssignedPatients();
        model.addAttribute("patients", patients);
        return "doctor/patients";
    }
    @GetMapping("/patients/{patientId}/history")
    public String viewPatientHistory(@PathVariable Long patientId, Model model) {
        var history = doctorService.getPatientMedicalHistory(patientId);
        model.addAttribute("history", history);
        return "doctor/patientHistory";
    }
    @GetMapping("/appointments")
    public String viewAppointments(Model model) {
        var appointments = doctorService.getAppointments();
        model.addAttribute("appointments", appointments);
        return "doctor/appointments";
    }

}
