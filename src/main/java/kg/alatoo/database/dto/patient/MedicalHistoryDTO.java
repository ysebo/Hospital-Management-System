package kg.alatoo.database.dto.patient;

import lombok.Data;

import java.util.List;

@Data
public class MedicalHistoryDTO {
    private Long patientId;
    private String fullName;
    private List<MedicalRecordDTO> records;
}
