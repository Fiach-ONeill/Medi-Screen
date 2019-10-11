package edu.cit.medics.service;

import edu.cit.medics.model.Medic;
import edu.cit.medics.repository.MedicRepository;
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
        Medic tmpMedic = medicRepository.findByEmail(emailOld);
        tmpMedic.setEmail(emailNew);
        medicRepository.save(tmpMedic);
    }

    @Override
    public void deleteMedic(String id) {
        medicRepository.deleteById(id);
    }
}
