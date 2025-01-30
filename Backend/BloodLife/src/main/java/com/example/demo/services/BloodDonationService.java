package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodDonation;
import com.example.demo.repositories.BloodDonationRepository;

@Service
public class BloodDonationService {
	
	 @Autowired
	 BloodDonationRepository brepo;
	 
	 public List <BloodDonation> findAll()
	 {
		 return brepo.findAll();
	 }
	 
	 public Optional <BloodDonation> findById(int id)
	 {
		 return brepo.findById(id);
	 }
	 
	 public BloodDonation save(BloodDonation blooddonation)
	 {
		 return brepo.save(blooddonation);
	 }
	 
	 public void deleteById(int id)
	 {
		 brepo.deleteById(id);
	 }

}
