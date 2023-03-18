package com.mindtree.comprehensiveAssessment.hospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int age;
	private char gender;
	private String specialisation = "";
		
	public Doctor() {}
	public Doctor(String name, int age, char gender, String[] specialisation) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		for(String spec : specialisation) {
			this.specialisation += " "+spec;
		}
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", age=" + age + ", gender=" + gender + ", specialisation=" + specialisation+"]";
	}
}
