package edu.cit.mediscreen.controller;

import edu.cit.mediscreen.model.Medic;
import edu.cit.mediscreen.service.MedicService;
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
        return medicService.findMedicByEmail(email);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> postMedic(@RequestBody Medic medic) {
        medicService.saveMedic(medic);
        return new ResponseEntity("Medic posted succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}")
    public ResponseEntity patchMedicEmail(@PathVariable("email") String emailOld, @RequestBody String emailNew) {
        medicService.updateMedicEmail(emailOld, emailNew);
        return new ResponseEntity("patched Medic Email succesfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{email}")
    public void deleteMedic(@PathVariable("email") String email) {
        medicService.deleteMedic(email);
    }
}
