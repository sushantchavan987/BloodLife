package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bloodbank")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bid;
	
	String bname;
	
	int reg_no;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	User user;


	public BloodBank() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BloodBank(int bid, String bname, int reg_no, User user) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.reg_no = reg_no;
		this.user = user;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public int getReg_no() {
		return reg_no;
	}


	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}