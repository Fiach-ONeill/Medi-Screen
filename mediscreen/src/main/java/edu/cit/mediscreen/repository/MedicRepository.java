package edu.cit.mediscreen.repository;

import edu.cit.mediscreen.model.Medic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicRepository extends MongoRepository<Medic, String> {

    Medic findByEmail(String email);
}
