package ma.groupe1.hospital.service;
import jakarta.transaction.Transactional;
import ma.groupe1.hospital.entities.Consultation;
import ma.groupe1.hospital.entities.Medecin;
import ma.groupe1.hospital.entities.Patient;
import ma.groupe1.hospital.entities.RendezVous;
import ma.groupe1.hospital.repositories.ConsultationRepository;
import ma.groupe1.hospital.repositories.MedecinRepository;
import ma.groupe1.hospital.repositories.PatientRepository;
import ma.groupe1.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    public HospitalServiceImpl(PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
