package edu.cit.patients.service;

import edu.cit.patients.model.Patient;
import edu.cit.patients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByMedicCode(String medicCode) {
        return patientRepository.findByMedicCode(medicCode);
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public void savePatient(Patient patient) {
        patient.setCreatedDate();
        patientRepository.save(patient);
    }

    @Override
    public void updatePatientInfo(String emailOld, String emailNew) {
        Patient dbPatient = patientRepository.findByEmail(emailOld);
        dbPatient.setEmail(emailNew);
        patientRepository.save(dbPatient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
