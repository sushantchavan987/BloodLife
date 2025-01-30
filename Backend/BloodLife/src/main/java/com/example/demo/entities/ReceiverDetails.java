package com.example.demo.entities;

public class ReceiverDetails {
	
	int bloodTypeId;
	
	String r_name;
	
	char gender;
	
	int age;

	public ReceiverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiverDetails(int bloodTypeId, String r_name, char gender, int age) {
		super();
		this.bloodTypeId = bloodTypeId;
		this.r_name = r_name;
		this.gender = gender;
		this.age = age;
	}

	public int getBloodTypeId() {
		return bloodTypeId;
	}

	public void setBloodTypeId(int bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
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
	
	
	

}