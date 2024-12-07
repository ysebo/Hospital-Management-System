package kg.alatoo.database.dto.patient;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public  class MedicalRecordDTO {
    private LocalDateTime date;
    private String details;
    public MedicalRecordDTO(LocalDateTime date, String details) {
        this.date = date;
        this.details = details;
    }
}