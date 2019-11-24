package edu.cit.mediscreen.repository;

import edu.cit.mediscreen.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByEmail(String email);

    List<Patient> findByMedicCode(String medicCode);
}
