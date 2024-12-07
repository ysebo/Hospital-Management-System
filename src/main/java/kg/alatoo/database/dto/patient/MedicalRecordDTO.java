package kg.alatoo.database.dto.patient;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public  class MedicalRecordDTO {
    private LocalDateTime date;
    private String details;
}