package com.example.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exceptions.ResourcesNotFoundException;
import com.example.backend.model.Patient;
import com.example.backend.patientrepository.PatientRepository;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientRepository patientRepo;
	
	//get all patients
	@GetMapping
	public List<Patient> getAllPatients()
	{
		return patientRepo.findAll();
	}
	
	//add a patient
	@PostMapping("/add")
	private Patient createPatient(@RequestBody Patient patient) {
		return patientRepo.save(patient);
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id)
	{
		Patient patient = patientRepo.findById(id).orElseThrow(() ->  new ResourcesNotFoundException("patient not found"));
		return  ResponseEntity.ok(patient);
	}
	//update a patient
	@PutMapping("/updatepatient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patientDetails )
	{
		Patient patient = patientRepo.findById(id).orElseThrow(() ->  new ResourcesNotFoundException("patient not found"));
		 
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setDiagnosis(patientDetails.getDiagnosis());
		patient.setAddress(patientDetails.getAddress());
		patient.setPhoneNumber(patientDetails.getPhoneNumber());
		patient.setMdName(patientDetails.getMdName());
		
		Patient updatedPatient = patientRepo.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	//delete a patient
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable int id){
		Patient patient = patientRepo.findById(id).orElseThrow(() ->  new ResourcesNotFoundException("patient not found"));
		  patientRepo.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
