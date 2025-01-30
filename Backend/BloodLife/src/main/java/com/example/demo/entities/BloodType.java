package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bloodtype")
public class BloodType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bloodtype_id;
	
	String name;
	
	@OneToMany(mappedBy = "bloodtype")
	List <Donor> donors;
	
	@OneToMany(mappedBy = "bloodtype")
	List <Receiver> receivers;
	
	

	public BloodType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BloodType(int bloodtype_id, String name, List<Donor> donors, List<Receiver> receivers) {
		super();
		this.bloodtype_id = bloodtype_id;
		this.name = name;
		this.donors = donors;
		this.receivers = receivers;
	}



	public int getBloodtype_id() {
		return bloodtype_id;
	}

	public void setBloodtype_id(int bloodtype_id) {
		this.bloodtype_id = bloodtype_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Donor> getDonors() {
		return donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}

	public List<Receiver> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}


}
