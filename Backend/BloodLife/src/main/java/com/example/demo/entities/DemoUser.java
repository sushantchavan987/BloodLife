package com.example.demo.entities;

public class DemoUser {
	
    int uid;
	
	String name;
	
	String password;
	
	String contact;
	
	String address;
	
	Integer cityId; 
	
	Integer role;
	
	String rname;
	
	BloodBankDetails bloodBankDetails;
	
	DonorDetails donorDetails;
	
	ReceiverDetails receiverDetails;

	public DemoUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoUser(int uid, String name, String password, String contact, String address, Integer cityId, Integer role,
			String rname, BloodBankDetails bloodBankDetails, DonorDetails donorDetails,
			ReceiverDetails receiverDetails) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.contact = contact;
		this.address = address;
		this.cityId = cityId;
		this.role = role;
		this.rname = rname;
		this.bloodBankDetails = bloodBankDetails;
		this.donorDetails = donorDetails;
		this.receiverDetails = receiverDetails;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public BloodBankDetails getBloodBankDetails() {
		return bloodBankDetails;
	}

	public void setBloodBankDetails(BloodBankDetails bloodBankDetails) {
		this.bloodBankDetails = bloodBankDetails;
	}

	public DonorDetails getDonorDetails() {
		return donorDetails;
	}

	public void setDonorDetails(DonorDetails donorDetails) {
		this.donorDetails = donorDetails;
	}

	public ReceiverDetails getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(ReceiverDetails receiverDetails) {
		this.receiverDetails = receiverDetails;
	}
	
	


	
}
