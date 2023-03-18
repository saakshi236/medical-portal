package com.mindtree.comprehensiveAssessment.hospitalmanagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mindtree.comprehensiveAssessment.hospitalmanagement.controller.DoctorModuleController;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Doctor;
import com.mindtree.comprehensiveAssessment.hospitalmanagement.repository.DoctorImplRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class DoctorModuleControllerTest {

	@InjectMocks
	DoctorModuleController controller;

	@Mock
	DoctorImplRepository repository;

	Doctor doctorTestRec1 = new Doctor("Lokesh", 25, 'M', new String[] { "Neuro", "Surgery" });
	Doctor doctorTestRec2 = new Doctor("Sureli", 34, 'F', new String[] { "Anatomy", "Surgery" });

	@Test
	public void testAddDoctor() {
		Mockito.when(repository.save(any(Doctor.class))).thenReturn(doctorTestRec1);
		assertEquals(controller.addDoctor(doctorTestRec1), 200);
	}

	@Test
	public void testGetAllDoctors() {
		List<Doctor> listDoc = Arrays.asList(doctorTestRec1, doctorTestRec2);
		when(controller.displayListOfDoctors()).thenReturn(listDoc);
		assertEquals(controller.displayListOfDoctors(), listDoc);
	}

	@Test
	public void testDeleteDoctor() {
		repository.deleteById(1);
		verify(repository).deleteById(1);
	}

	@Test
	public void testgetDoctorByName() {
		Mockito.when(repository.getDoctorById(2)).thenReturn(doctorTestRec2);
		assertEquals(repository.getDoctorById(2), doctorTestRec2);
	}
}
