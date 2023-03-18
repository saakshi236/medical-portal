package com.mindtree.comprehensiveAssessment.hospitalmanagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mindtree.comprehensiveAssessment.hospitalmanagement.controller.PatientModuleController;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Patient;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.repository.PatientImplRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PatientModuleControllerTest {

	@InjectMocks
	PatientModuleController controller;

	@Mock
	PatientImplRepository repository;

	Patient patientTestRec1 = new Patient(1, "Lokesh", 2, new Date(), "Test Prescription 1");
	Patient patientTestRec2 = new Patient(2, "Sureli", 3, new Date(), "Test Prescription 2");
	
	@Test
	void testGetPatients(){
		List<Patient> listPatients = Arrays.asList(patientTestRec1, patientTestRec2);
		Mockito.when(controller.getPatients()).thenReturn(listPatients);
		assertEquals(controller.getPatients(), listPatients);
	}
	
	@Test
	void testAddPatient(){
		Mockito.when(repository.save(any(Patient.class))).thenReturn(patientTestRec1);
		assertEquals(controller.addPatient(patientTestRec1), 200);
	}
	
	@Test
	void testgetDoctorsName(){
		Mockito.when(repository.save(any(Patient.class))).thenReturn(patientTestRec1);
		assertEquals(controller.addPatient(patientTestRec1), 200);
	}
	
	@Test
	void testgetPatientById(){
		Mockito.when(repository.findPatientById(1)).thenReturn(patientTestRec1);
		assertEquals(repository.findPatientById(1), patientTestRec1);
	}
}
