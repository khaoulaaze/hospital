package ma.groupe1.hospital;

import ma.groupe1.hospital.entities.*;
import ma.groupe1.hospital.repositories.ConsultationRepository;
import ma.groupe1.hospital.repositories.MedecinRepository;
import ma.groupe1.hospital.repositories.PatientRepository;
import ma.groupe1.hospital.repositories.RendezVousRepository;
import ma.groupe1.hospital.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(HospitalService hospitalService,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository,
							MedecinRepository medecinRepository){

		return args -> {
			Stream.of("Aya","Hafsa","Khaoula")
					.forEach(name -> {hospitalService.savePatient(
							new Patient(null,name,new Date(),false,null)
							);
						}
					);

			Stream.of("Manal","Aymane","Hassan")
					.forEach(name -> {hospitalService.saveMedecin(
									new Medecin(null,name,name+"@gmail.com",Math.random()>0.5?"Cardio":"Dentiste",null)
							);
							}
					);

			Patient patient= patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Khaoula");

			Medecin medecin= medecinRepository.findByNom("Aymane");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous savedRDV =hospitalService.saveRDV(rendezVous);
			System.out.println(savedRDV.getId());

			//RendezVous rendezVous1 =rendezVousRepository.findById(1L).orElse(null);
			RendezVous rendezVous1 =rendezVousRepository.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de consultation ......");
			hospitalService.saveConsultation(consultation);
		};
	}

}
