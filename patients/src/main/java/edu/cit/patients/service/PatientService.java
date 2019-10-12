package edu.cit.patients.service;

import edu.cit.patients.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    List<Patient> findByMedicCode(String medicCode);

    Patient findByEmail(String email);

    void savePatient(Patient patient);

    void updatePatientInfo(String email, Patient patient);

    void updatePatientEmail(String emailOld, String emailNew);

    void updateHeartDiseaseInfo(String email, Patient patient);

    void updateDiabetesInfo(String email, Patient patient);

    void updateBreastCancerInfo(String email, Patient patient);

    void deletePatient(String id);
}
