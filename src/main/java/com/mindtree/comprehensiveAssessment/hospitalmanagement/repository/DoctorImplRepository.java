package com.mindtree.comprehensiveAssessment.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.comprehensiveAssessment.hospitalmanagement.model.Doctor;

public interface DoctorImplRepository extends JpaRepository<Doctor, Integer>{
	public Doctor getDoctorById(Integer id);
}
