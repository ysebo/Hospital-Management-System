package kg.alatoo.database.service;

import kg.alatoo.database.dto.appointment.AppointmentDTO;
import kg.alatoo.database.dto.patient.MedicalHistoryDTO;
import kg.alatoo.database.entity.Doctor;
import kg.alatoo.database.entity.Patient;

import java.util.List;

public interface PatientService {
    MedicalHistoryDTO getMedicalHistory(Long patientId);

    List<AppointmentDTO> getAppointments(Long patientId);

    List<Doctor> getAvailableDoctors();

    void cancelAppointment(Long appointmentId);

    Patient getPatientById(Long patientId);
}
