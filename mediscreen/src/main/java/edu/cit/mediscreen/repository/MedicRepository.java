package edu.cit.mediscreen.repository;

import edu.cit.mediscreen.model.Medic;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
interface for database access for entity 'medic'
@author: Simon Wolf
 */
public interface MedicRepository extends MongoRepository<Medic, String> {

    Medic findByEmail(String email);

    Medic findByPatientCode(String patientCode);
}
