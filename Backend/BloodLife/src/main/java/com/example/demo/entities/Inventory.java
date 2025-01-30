package com.example.demo.entities;

import java.sql.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inv_id;
	
	int qty;
	
	Date exp_date;
	
	char exp_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blood_donation_id")
	BloodDonation blooddonation;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(int inv_id, int qty, Date exp_date, char exp_status, BloodDonation blooddonation) {
		super();
		this.inv_id = inv_id;
		this.qty = qty;
		this.exp_date = exp_date;
		this.exp_status = exp_status;
		this.blooddonation = blooddonation;
	}

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public char getExp_status() {
		return exp_status;
	}

	public void setExp_status(char exp_status) {
		this.exp_status = exp_status;
	}

	public BloodDonation getBlooddonation() {
		return blooddonation;
	}

	public void setBlooddonation(BloodDonation blooddonation) {
		this.blooddonation = blooddonation;
	}
	
	

}
