package edu.cit.mediscreen.controller;

import edu.cit.mediscreen.model.Patient;
import edu.cit.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
Controller-class with router functionality for the REST interface for entity 'patient'
@author: Simon Wolf
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping(value = "/{email}")
    public Patient getPatientByEmail(@PathVariable("email") String email) {
        return patientService.findPatientByEmail(email);
    }

    @GetMapping(value = "/mediccode/{mediccode}")
    public List<Patient> getPatientsByMedicCode(@PathVariable("mediccode") String medicCode) {
        return patientService.findByMedicCode(medicCode);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> postPatient(@Valid @RequestBody Patient patient) {
        try {
            patientService.savePatient(patient);
            return new ResponseEntity("Patient posted succesfully", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity("Invalid Medic-code entered", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<?> putPatientInfo(@PathVariable("email") String email, @Valid @RequestBody Patient patient) {
        patientService.updatePatientInfo(email, patient);
        return new ResponseEntity("Patient Info put succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}")
    public ResponseEntity<?> patchPatientEmail(@PathVariable("email") String emailOld, @Valid @RequestBody String emailNew) {
        patientService.updatePatientEmail(emailOld, emailNew);
        return new ResponseEntity("patched Patient Email succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}/heart")
    public ResponseEntity<?> patchHeartDiseaseInfo(@PathVariable("email") String email, @Valid @RequestBody Patient patient) {
        patientService.updateHeartDiseaseInfo(email, patient);
        return new ResponseEntity("patched Heart Disease Info succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}/diabetes")
    public ResponseEntity<?> patchDiabetesInfo(@PathVariable("email") String email, @Valid @RequestBody Patient patient) {
        patientService.updateDiabetesInfo(email, patient);
        return new ResponseEntity("patched Diabetes Info succesfully", HttpStatus.OK);
    }

    @PatchMapping(value = "/{email}/breastcancer")
    public ResponseEntity<?> patchBreastCancerInfo(@PathVariable("email") String email, @Valid @RequestBody Patient patient) {
        patientService.updateBreastCancerInfo(email, patient);
        return new ResponseEntity("patched Breast Cancer Info succesfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        patientService.deletePatient(email);
    }
}
