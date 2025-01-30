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
@Table(name = "receiver")
public class Receiver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int r_id;
	
	String r_name;
	
	char gender;
	
	int age;
	
	@JsonIgnoreProperties("receivers")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodtype_id")
	BloodType bloodtype;
	
	@JsonIgnoreProperties("receivers")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	User user;
	
	public void setBloodTypeId(int bloodTypeId) {
        BloodType bloodType = new BloodType();
        bloodType.setBloodtype_id(bloodTypeId); // Assuming BloodType has a setId() method
        this.bloodtype = bloodType;
    }

	public Receiver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receiver(int r_id, String r_name, char gender, int age, BloodType bloodtype, User user) {
		super();
		this.r_id = r_id;
		this.r_name = r_name;
		this.gender = gender;
		this.age = age;
		this.bloodtype = bloodtype;
		this.user = user;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
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
