package com.mindtree.comprehensiveAssessment.hospitalmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Doctor;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.repository.DoctorImplRepository;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.service.DoctorService;

// to allow cross origin requests
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorModuleController {

	@Autowired
	DoctorService service;

	@Autowired
	DoctorImplRepository repository;

	// view all doctor details
	@RequestMapping(value = "/doctors")
	public List<Doctor> displayListOfDoctors() {
		List<Doctor> list = repository.findAll();
		return list;
	}

	// add doctor record
	@PostMapping("/doctors")
	public int addDoctor(@RequestBody Doctor doctor) {
		repository.save(doctor);
		return ResponseEntity.ok(repository.save(doctor)).getStatusCodeValue();
	}
	
	// find doctor by doctor id
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable Integer id) {
		Optional<Doctor> doc = repository.findById(id);
		System.err.println(id);
		System.err.println(ResponseEntity.ok(doc));
		return ResponseEntity.ok(doc);
	}

	// update doctor by record by doctor id
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Integer id, @RequestBody Doctor doctorDetails) {
		repository.deleteById(id);
		System.err.println(id);
		repository.save(doctorDetails);
		return ResponseEntity.ok(doctorDetails);
	}

	// delete doctor record by id
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Integer id) {
		repository.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		System.err.println(ResponseEntity.ok(response));
		return ResponseEntity.ok(response);
	}

	// get doctor's name by specific id and further fetching respective name
	@GetMapping("/doctors/details/{id}")
	public Doctor getDoctorByName(@PathVariable Integer id) {
		Doctor doc = repository.getDoctorById(id);
		return doc;
	}
}
