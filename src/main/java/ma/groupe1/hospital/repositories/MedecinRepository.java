package ma.groupe1.hospital.repositories;

import ma.groupe1.hospital.entities.Medecin;
import ma.groupe1.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
