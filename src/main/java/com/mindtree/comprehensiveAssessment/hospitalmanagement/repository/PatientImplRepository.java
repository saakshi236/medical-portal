package com.mindtree.comprehensiveAssessment.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Patient;

public interface PatientImplRepository extends JpaRepository<Patient, Integer>{

	public Patient findPatientById(Integer id);
}
