package kg.alatoo.database.service.impl;

import kg.alatoo.database.dto.appointment.AppointmentDTO;
import kg.alatoo.database.dto.patient.MedicalHistoryDTO;
import kg.alatoo.database.dto.patient.PatientDTO;
import kg.alatoo.database.repository.AppointmentRepository;
import kg.alatoo.database.repository.PatientRepository;
import kg.alatoo.database.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    public List<PatientDTO> getAssignedPatients() {
        return List.of();
    }

    public MedicalHistoryDTO getPatientMedicalHistory(Long patientId) {
        return null;
    }

    public List<AppointmentDTO> getAppointments() {
        return List.of();
    }
}
