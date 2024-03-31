package ma.groupe1.hospital.service;

import ma.groupe1.hospital.entities.Consultation;
import ma.groupe1.hospital.entities.Medecin;
import ma.groupe1.hospital.entities.Patient;
import ma.groupe1.hospital.entities.RendezVous;

public interface HospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
