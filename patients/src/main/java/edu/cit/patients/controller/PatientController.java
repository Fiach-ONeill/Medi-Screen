package edu.cit.patients.controller;

import edu.cit.patients.model.Patient;
import edu.cit.patients.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping(value = "?medicCode=")
    public List<Patient> getPatientsByMedicCode(@RequestParam String medicCode) {
        return patientService.findByMedicCode(medicCode);
    }

    @GetMapping(value = "/{email}")
    public Patient getPatientByEmail(@PathVariable("email") String email) {
        return patientService.findByEmail(email);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> savePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return new ResponseEntity("Patient added succesfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<?> updatePatientInfo(@PathVariable("email") String email, @RequestBody Patient patient) {
        patientService.updatePatientInfo(email, patient);
        return new ResponseEntity("Patient updated succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}")
    public ResponseEntity<?> updatePatientEmail(@PathVariable("email") String emailOld, @RequestBody String emailNew) {
        patientService.updatePatientEmail(emailOld, emailNew);
        return new ResponseEntity("Patient Email updated succesfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        patientService.deletePatient(patientService.findByEmail(email).getId());
    }
}
