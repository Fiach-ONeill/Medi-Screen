package edu.cit.medics.service;

import edu.cit.medics.model.Medic;
import edu.cit.medics.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MedicServiceImpl implements MedicService {

    @Autowired
    private MedicRepository medicRepository;

    @Override
    public List<Medic> findAll() {
        return medicRepository.findAll();
    }

    @Override
    public Medic findByEmail(String email) {
        return medicRepository.findByEmail(email);
    }

    @Override
    public void saveMedic(Medic medic) {
        medic.setCreatedDate();
        medic.setPatientCode();
        medicRepository.save(medic);
    }

    @Override
    public void updateMedicEmail(String emailOld, String emailNew) {
        Medic dbMedic = medicRepository.findByEmail(emailOld);
        dbMedic.setEmail(emailNew);
        medicRepository.save(dbMedic);
    }

    @Override
    public void deleteMedic(String id) {
        medicRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> getPatientByMedicCode(String medicCode) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "localhost:8081/patients?medicCode=" + medicCode;
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response;
    }
}
