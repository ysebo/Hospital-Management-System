package kg.alatoo.database.repository;

import kg.alatoo.database.entity.Appointment;
import kg.alatoo.database.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId")
    List<Appointment> findAppointmentsByDoctorId(Long doctorId);

    @Query("SELECT DISTINCT a.patient FROM Appointment a WHERE a.doctor.id = :doctorId")
    List<Patient> findPatientsByDoctorId(Long doctorId);
    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId")
    List<Appointment> findAppointmentsByPatientId(Long patientId);
}
