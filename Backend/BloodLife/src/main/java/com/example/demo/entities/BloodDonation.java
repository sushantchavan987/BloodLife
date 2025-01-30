package com.example.demo.entities;

import java.sql.Date;

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
@Table(name = "blood_donation")
public class BloodDonation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int blood_donation_id;
	
	Date date;
	
	char status;
	
	@JsonIgnoreProperties("donors")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	Donor donor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bid")
	BloodBank bloodbank;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodtype_id")
	BloodType bloodtype;

	public BloodDonation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodDonation(int blood_donation_id, Date date, char status, Donor donor, BloodBank bloodbank,
			BloodType bloodtype) {
		super();
		this.blood_donation_id = blood_donation_id;
		this.date = date;
		this.status = status;
		this.donor = donor;
		this.bloodbank = bloodbank;
		this.bloodtype = bloodtype;
	}

	public int getBlood_donation_id() {
		return blood_donation_id;
	}

	public void setBlood_donation_id(int blood_donation_id) {
		this.blood_donation_id = blood_donation_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public BloodBank getBloodbank() {
		return bloodbank;
	}

	public void setBloodbank(BloodBank bloodbank) {
		this.bloodbank = bloodbank;
	}

	public BloodType getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(BloodType bloodtype) {
		this.bloodtype = bloodtype;
	}
	
	
	
    
}
