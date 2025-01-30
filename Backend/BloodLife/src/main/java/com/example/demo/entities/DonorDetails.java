package com.example.demo.entities;

public class DonorDetails {
	
	int bloodTypeId;
	
	String dname;
	
	char gender;
	
	int age;
	
	String medicalHistory;

	public DonorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonorDetails(int bloodTypeId, String dname, char gender, int age, String medicalHistory) {
		super();
		this.bloodTypeId = bloodTypeId;
		this.dname = dname;
		this.gender = gender;
		this.age = age;
		this.medicalHistory = medicalHistory;
	}

	public int getBloodTypeId() {
		return bloodTypeId;
	}

	public void setBloodTypeId(int bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
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

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	

}
