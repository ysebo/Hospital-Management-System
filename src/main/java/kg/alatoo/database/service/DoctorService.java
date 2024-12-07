package kg.alatoo.database.service;

import kg.alatoo.database.dto.appointment.AppointmentDTO;
import kg.alatoo.database.dto.patient.MedicalHistoryDTO;
import kg.alatoo.database.dto.patient.PatientDTO;

import java.util.List;

public interface DoctorService {

    List<PatientDTO> getAssignedPatients();
    MedicalHistoryDTO getPatientMedicalHistory(Long patientId);
    List<AppointmentDTO> getAppointments();
}
