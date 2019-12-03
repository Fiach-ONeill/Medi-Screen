package edu.cit.mediscreen.service;

import edu.cit.mediscreen.model.Patient;

import java.util.List;

/*
interface for service logic for entity 'patient'
@author: Simon Wolf
 */
public interface PatientService {

    List<Patient> findAll();

    List<Patient> findByMedicCode(String medicCode);

    Patient findPatientByEmail(String email);

    void savePatient(Patient patient);

    void updatePatientInfo(String email, Patient patient);

    void updatePatientEmail(String emailOld, String emailNew);

    void updateHeartDiseaseInfo(String email, Patient patient);

    void updateDiabetesInfo(String email, Patient patient);

    void updateBreastCancerInfo(String email, Patient patient);

    void deletePatient(String email);
}
