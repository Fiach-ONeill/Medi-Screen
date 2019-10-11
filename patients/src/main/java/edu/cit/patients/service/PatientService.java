package edu.cit.patients.service;

import edu.cit.patients.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    List<Patient> findByMedicCode(String medicCode);

    Patient findByEmail(String email);

    void savePatient(Patient patient);

    void updatePatientInfo(String emailOld, String emailNew);

    void deletePatient(String id);
}
