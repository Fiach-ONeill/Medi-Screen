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
    public void updatePatientInfo(String email, Patient patient) {
        Patient dbPatient = patientRepository.findByEmail(email);
        patient.setId(dbPatient.getId());
        patient.setVersion(dbPatient.getVersion());
        patient.setCreatedDate(dbPatient.getCreatedDate());
        patientRepository.save(patient);
    }

    @Override
    public void updatePatientEmail(String emailOld, String emailNew) {
        Patient dbPatient = patientRepository.findByEmail(emailOld);
        dbPatient.setEmail(emailNew);
        patientRepository.save(dbPatient);
    }

    @Override
    public void updateHeartDiseaseInfo(String email, Patient patient) {
        Patient dbPatient = patientRepository.findByEmail(email);
        dbPatient.setCp(patient.getCp());
        dbPatient.setTrestbps(patient.getTrestbps());
        dbPatient.setCholesterol(patient.getCholesterol());
        dbPatient.setFbs(patient.getFbs());
        dbPatient.setThalach(patient.getThalach());
        dbPatient.setExang(patient.getExang());
        dbPatient.setOldpeak(patient.getOldpeak());
        dbPatient.setSlope(patient.getSlope());
        dbPatient.setCa(patient.getCa());
        patientRepository.save(dbPatient);
    }

    @Override
    public void updateDiabetesInfo(String email, Patient patient) {
        Patient dbPatient = patientRepository.findByEmail(email);
        dbPatient.setNoPregnancies(patient.getNoPregnancies());
        dbPatient.setGlucose(patient.getGlucose());
        dbPatient.setBloodPressure(patient.getBloodPressure());
        dbPatient.setSkinThickness(patient.getSkinThickness());
        dbPatient.setInsulin(patient.getInsulin());
        dbPatient.setBmi(patient.getBmi());
        dbPatient.setDiabetesPedigree(patient.getDiabetesPedigree());
        patientRepository.save(dbPatient);
    }

    @Override
    public void updateBreastCancerInfo(String email, Patient patient) {
        Patient dbPatient = patientRepository.findByEmail(email);
        dbPatient.setMeanSmoothness(patient.getMeanSmoothness());
        dbPatient.setMeanArea(patient.getMeanArea());
        dbPatient.setMeanPerimeter(patient.getMeanPerimeter());
        dbPatient.setMeanTexture(patient.getMeanTexture());
        dbPatient.setMeanRadius(patient.getMeanRadius());
        patientRepository.save(dbPatient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
