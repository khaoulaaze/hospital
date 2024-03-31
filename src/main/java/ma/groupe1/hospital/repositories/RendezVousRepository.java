package ma.groupe1.hospital.repositories;

import ma.groupe1.hospital.entities.Medecin;
import ma.groupe1.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
