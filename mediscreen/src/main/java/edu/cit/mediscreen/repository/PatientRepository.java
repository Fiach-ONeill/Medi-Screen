package edu.cit.mediscreen.repository;

import edu.cit.mediscreen.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
interface for database access for entity 'patient'
@author: Simon Wolf
 */
public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByEmail(String email);

    List<Patient> findByMedicCode(String medicCode);
}
