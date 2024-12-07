package kg.alatoo.database.dto.patient;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String history;
}
