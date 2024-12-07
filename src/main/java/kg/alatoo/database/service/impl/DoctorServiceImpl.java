package kg.alatoo.database.service.impl;
import kg.alatoo.database.dto.appointment.AppointmentDTO;
import kg.alatoo.database.dto.patient.MedicalHistoryDTO;
import kg.alatoo.database.dto.patient.MedicalRecordDTO;
import kg.alatoo.database.dto.patient.PatientDTO;
import kg.alatoo.database.entity.Appointment;
import kg.alatoo.database.entity.Patient;
import kg.alatoo.database.exception.CustomException;
import kg.alatoo.database.mapper.PatientMapper;
import kg.alatoo.database.repository.AppointmentRepository;
import kg.alatoo.database.repository.PatientRepository;
import kg.alatoo.database.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientMapper patientMapper;
    public List<PatientDTO> getAssignedPatients(Long doctorId) {
        List<Patient> patients = appointmentRepository.findPatientsByDoctorId(doctorId);
        return patients.stream()
                .map(patient -> patientMapper.toDto(patient))
                .collect(Collectors.toList());
    }

    public MedicalHistoryDTO getPatientMedicalHistory(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new CustomException("Patient not found!", HttpStatus.NOT_FOUND));

        List<MedicalRecordDTO> medicalRecords = patient.getMedicalRecords().stream()
                .map(record -> new MedicalRecordDTO(record.getDate(), record.getDetails()))
                .collect(Collectors.toList());
        MedicalHistoryDTO medicalHistoryDTO = new MedicalHistoryDTO();
        medicalHistoryDTO.setRecords(medicalRecords);
        return medicalHistoryDTO;
    }

    public List<AppointmentDTO> getAppointments(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctorId);
        return appointments.stream()
                .map(appointment -> {
                    AppointmentDTO appointmentDTO = new AppointmentDTO();
                    appointmentDTO.setId(appointment.getId());
                    appointmentDTO.setPatient(patientMapper.toDto(appointment.getPatient()));
                    appointmentDTO.setTime(appointment.getAppointmentDate());
                    appointmentDTO.setStatus(appointment.getStatus().toString());
                    return appointmentDTO;
                })
                .collect(Collectors.toList());
    }
}
