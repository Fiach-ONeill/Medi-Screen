package edu.cit.medics.service;

import edu.cit.medics.model.Medic;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicService {

    List<Medic> findAll();

    Medic findByEmail(String email);

    void saveMedic(Medic medic);

    void updateMedicEmail(String emailOld, String emailNew);

    void deleteMedic(String id);


    ResponseEntity getPatientByMedicCode(String medicCode);
}
