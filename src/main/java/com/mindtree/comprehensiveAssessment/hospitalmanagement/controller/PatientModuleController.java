package com.mindtree.comprehensiveAssessment.hospitalmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Doctor;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Patient;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.repository.DoctorImplRepository;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.repository.PatientImplRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientModuleController {

	@Autowired
	PatientImplRepository repository;
	
	@Autowired
	DoctorImplRepository doctorRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// specifying date format as dd/mm/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// get all patients records
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		List<Patient> patient = repository.findAll();
		return patient;
	}
	
	// get patient record by id
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable Integer id) {
		Patient doc = repository.findPatientById(id);
		return doc;
	}

	// add Patient
	@PostMapping("/patients")
	public int addPatient(@RequestBody Patient patient) {
		repository.save(patient);
		return ResponseEntity.ok(repository.save(patient)).getStatusCodeValue();
	}

	@GetMapping("/patients/doctor/{id}")
	public String getDoctorsName(@PathVariable Integer id) {
		Patient patient = repository.findPatientById(id);
		Integer docId = patient.getDoctor();
		Doctor doctor = doctorRepository.getDoctorById(docId);
		return doctor.getName();
	}
	
	@GetMapping("/patients/count/{id}")
	public Integer getPatientCount(@PathVariable Integer id) {
		int count = 0;
		List<Patient> patientList = repository.findAll();
		for(int i=0; i<patientList.size(); i++) {
			if(patientList.get(i).getDoctor() == id) {
				count++;
			}
		}
		return count;
	}
}
