package ma.groupe1.hospital.repositories;

import ma.groupe1.hospital.entities.Consultation;
import ma.groupe1.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
