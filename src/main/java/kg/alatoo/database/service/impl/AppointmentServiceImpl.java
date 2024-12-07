package kg.alatoo.database.service.impl;

import kg.alatoo.database.entity.Appointment;
import kg.alatoo.database.repository.AppointmentRepository;
import kg.alatoo.database.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
