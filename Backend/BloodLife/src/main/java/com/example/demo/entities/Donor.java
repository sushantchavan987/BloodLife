package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donor")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int d_id;
	
	String dname;
	
	char gender;
	
	int age;
	
	String medical_history;
	
	@JsonIgnoreProperties("donors")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodtype_id")
	BloodType bloodtype;
	
	@JsonIgnoreProperties("donors")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	User user;
	
	  public void setBloodTypeId(int bloodTypeId) {
	        BloodType bloodType = new BloodType();
	        bloodType.setBloodtype_id(bloodTypeId); // Assuming BloodType has a setId() method
	        this.bloodtype = bloodType;
	    }

	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donor(int d_id, String dname, char gender, int age, String medical_history, BloodType bloodtype, User user) {
		super();
		this.d_id = d_id;
		this.dname = dname;
		this.gender = gender;
		this.age = age;
		this.medical_history = medical_history;
		this.bloodtype = bloodtype;
		this.user = user;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(String medical_history) {
		this.medical_history = medical_history;
	}

	public BloodType getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(BloodType bloodtype) {
		this.bloodtype = bloodtype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
