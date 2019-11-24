package edu.cit.mediscreen.service;

import edu.cit.mediscreen.model.Medic;

import java.util.List;

public interface MedicService {

    List<Medic> findAll();

    Medic findMedicByEmail(String email);

    void saveMedic(Medic medic);

    void updateMedicEmail(String emailOld, String emailNew);

    void deleteMedic(String email);
}
