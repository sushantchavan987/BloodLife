package com.example.demo.entities;

public class BloodBankDetails {
	
	String bname;
	
	int reg_no;

	public BloodBankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodBankDetails(String bname, int reg_no) {
		super();
		this.bname = bname;
		this.reg_no = reg_no;
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
	
	

}
