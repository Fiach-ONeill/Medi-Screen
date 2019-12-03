package edu.cit.mediscreen.service;

import edu.cit.mediscreen.model.Medic;

import java.util.List;

/*
interface for service logic for entity 'medic'
@author: Simon Wolf
 */
public interface MedicService {

    List<Medic> findAll();

    Medic findMedicByEmail(String email);

    Medic findMedicByPatientCode(String patientCode);

    void saveMedic(Medic medic);

    void updateMedicEmail(String emailOld, String emailNew);

    void deleteMedic(String email);
}
