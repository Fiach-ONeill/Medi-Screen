package edu.cit.mediscreen.service;

import edu.cit.mediscreen.model.Medic;
import edu.cit.mediscreen.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Medic findMedicByEmail(String email) {
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
        Medic medicDb = medicRepository.findByEmail(emailOld);
        medicDb.setEmail(emailNew);
        medicRepository.save(medicDb);
    }

    @Override
    public void deleteMedic(String email) {
        String id = medicRepository.findByEmail(email).getId();
        medicRepository.deleteById(id);
    }
}
