package kg.alatoo.database.mapper;

import kg.alatoo.database.dto.patient.PatientDTO;
import kg.alatoo.database.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(source = "user.fullName", target = "fullName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phoneNumber", target = "phoneNumber")
    PatientDTO toDto(Patient patient);

    @Mapping(source = "fullName", target = "user.fullName")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "phoneNumber", target = "user.phoneNumber")
    Patient toEntity(PatientDTO patientDTO);
}
