package edu.cit.mediscreen.service;

import edu.cit.mediscreen.model.Medic;
import edu.cit.mediscreen.model.Patient;
import edu.cit.mediscreen.repository.MedicRepository;
import edu.cit.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
class that implements interface 'PatientService' for service logic
@author: Simon Wolf
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicRepository medicRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByMedicCode(String medicCode) {
        return patientRepository.findByMedicCode(medicCode);
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public void savePatient(Patient patient) {
        Medic medic = medicRepository.findByPatientCode(patient.getMedicCode());
        String medicCode = medic.getPatientCode();
        if(!medicCode.equals(patient.getMedicCode())) {
            throw new NullPointerException();
        }
        patient.setCreatedDate();
        patientRepository.save(patient);

    }

    @Override
    public void updatePatientInfo(String email, Patient patient) {
        Patient patientDb = patientRepository.findByEmail(email);
        patient.setId(patientDb.getId());
        patient.setVersion(patientDb.getVersion());
        patient.setCreatedDate(patientDb.getCreatedDate());
        patientRepository.save(patient);
    }

    @Override
    public void updatePatientEmail(String emailOld, String emailNew) {
        Patient patientDb = patientRepository.findByEmail(emailOld);
        patientDb.setEmail(emailNew);
        patientRepository.save(patientDb);
    }

    @Override
    public void updateHeartDiseaseInfo(String email, Patient patient) {
        Patient patientDb = patientRepository.findByEmail(email);
        patientDb.setCp(patient.getCp());
        patientDb.setTrestbps(patient.getTrestbps());
        patientDb.setCholesterol(patient.getCholesterol());
        patientDb.setFbs(patient.getFbs());
        patientDb.setThalach(patient.getThalach());
        patientDb.setExang(patient.getExang());
        patientDb.setOldpeak(patient.getOldpeak());
        patientDb.setSlope(patient.getSlope());
        patientDb.setCa(patient.getCa());
        patientRepository.save(patientDb);
    }

    @Override
    public void updateDiabetesInfo(String email, Patient patient) {
        Patient patientDb = patientRepository.findByEmail(email);
        patientDb.setNoPregnancies(patient.getNoPregnancies());
        patientDb.setGlucose(patient.getGlucose());
        patientDb.setBloodPressure(patient.getBloodPressure());
        patientDb.setSkinThickness(patient.getSkinThickness());
        patientDb.setInsulin(patient.getInsulin());
        patientDb.setBmi(patient.getBmi());
        patientDb.setDiabetesPedigree(patient.getDiabetesPedigree());
        patientRepository.save(patientDb);
    }

    @Override
    public void updateBreastCancerInfo(String email, Patient patient) {
        Patient patientDb = patientRepository.findByEmail(email);
        patientDb.setMeanSmoothness(patient.getMeanSmoothness());
        patientDb.setMeanArea(patient.getMeanArea());
        patientDb.setMeanPerimeter(patient.getMeanPerimeter());
        patientDb.setMeanTexture(patient.getMeanTexture());
        patientDb.setMeanRadius(patient.getMeanRadius());
        patientRepository.save(patientDb);
    }

    @Override
    public void deletePatient(String email) {
        String id = patientRepository.findByEmail(email).getId();
        patientRepository.deleteById(id);
    }
}
