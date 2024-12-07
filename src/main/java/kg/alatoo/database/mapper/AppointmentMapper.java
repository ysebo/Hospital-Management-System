package kg.alatoo.database.mapper;
import kg.alatoo.database.dto.appointment.AppointmentDTO;
import kg.alatoo.database.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDTO toDto(Appointment appointment);
}