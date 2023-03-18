package com.mindtree.comprehensiveAssessment.hospitalmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

//	id, name , visitedDoctor, dateOfVisit

	@Id
	@GeneratedValue
	private int id;
	private String name;

	private int doctor;

	@Column(name = "visitingdate")
	private Date dateOfVisit;

	private String prescription;

	public Patient() {
	}

	public Patient(int id, String name, int doctor, Date dateOfVisit, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.doctor = doctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getDoctor() {
		return doctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public String getPrescription() {
		return prescription;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", visitedDoctor=" + doctor + ", dateOfVisit="
				+ dateOfVisit + ", prescription=" + prescription + "]";
	}

}
