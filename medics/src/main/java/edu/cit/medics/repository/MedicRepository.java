package edu.cit.medics.repository;

import edu.cit.medics.model.Medic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicRepository extends MongoRepository<Medic, String> {

    Medic findByEmail(String eMail);
}
