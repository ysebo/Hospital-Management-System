package kg.alatoo.database.dto.appointment;

import kg.alatoo.database.dto.patient.PatientDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private PatientDTO patient;
    private LocalDateTime time;
    private String status;
}