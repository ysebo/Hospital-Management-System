package kg.alatoo.database.repository;

import kg.alatoo.database.entity.Doctor;
import kg.alatoo.database.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
