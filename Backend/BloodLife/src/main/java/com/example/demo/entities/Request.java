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
@Table(name = "request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int req_id;
	
	Date date;
	
	int qty;
	
	String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodtype_id")
	BloodType bloodtype;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int req_id, Date date, int qty, String status, BloodType bloodtype) {
		super();
		this.req_id = req_id;
		this.date = date;
		this.qty = qty;
		this.status = status;
		this.bloodtype = bloodtype;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BloodType getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(BloodType bloodtype) {
		this.bloodtype = bloodtype;
	}
	
	

}
