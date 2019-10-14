package edu.cit.medics.controller;

import edu.cit.medics.model.Medic;
import edu.cit.medics.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping(value = "")
    public List<Medic> getAllMedics() {
        return medicService.findAll();
    }

    @GetMapping(value = "/{email}")
    public Medic getMedicByEmail(@PathVariable("email") String email) {
        return medicService.findByEmail(email);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveMedic(@RequestBody Medic medic) {
        medicService.saveMedic(medic);
        return new ResponseEntity("Medic added succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}")
    public ResponseEntity<?> updateMedicEmail(@PathVariable("email") String emailOld, @RequestBody String emailNew) {
        medicService.updateMedicEmail(emailOld, emailNew);
        return new ResponseEntity("Medic Email updated succesfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{email}")
    public void deleteMedic(@PathVariable("email") String email) {
        medicService.deleteMedic(medicService.findByEmail(email).getId());
    }

    @GetMapping(value = "/patients/{medicCode}")
    public void getPatientsByMedicCode(@PathVariable("medicCode") String medicCode) {
        medicService.getPatientByMedicCode(medicCode);
    }
}
