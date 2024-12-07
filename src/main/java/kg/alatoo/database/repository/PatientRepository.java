package kg.alatoo.database.repository;
import kg.alatoo.database.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.user.id = :userId")
    Optional<Patient> findByUserId(Long userId);

    @Query("SELECT p FROM Patient p JOIN FETCH p.medicalRecords WHERE p.id = :patientId")
    Optional<Patient> findByIdWithMedicalRecords(Long patientId);
}
