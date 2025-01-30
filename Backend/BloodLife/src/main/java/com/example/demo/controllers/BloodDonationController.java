package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodDonation;
import com.example.demo.services.BloodDonationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/blood-donations")
public class BloodDonationController {
	
	@Autowired
	BloodDonationService bservice;
	
	@GetMapping
	public List <BloodDonation> getAllBloodDonations()
	{
		return bservice.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <BloodDonation> getBloodDonationById(@PathVariable int id)
	{
		return bservice.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public BloodDonation createBloodDonation(@RequestBody BloodDonation blooddonation)
	{
		return bservice.save(blooddonation);
	}
	
	@PutMapping
	public ResponseEntity <BloodDonation> updateBloodDonation(@PathVariable int id, @RequestBody BloodDonation blooddonation)
	{
		return bservice.findById(id)
				.map(existing -> {
					blooddonation.setBlood_donation_id(existing.getBlood_donation_id());
					return ResponseEntity.ok(bservice.save(blooddonation));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodDonation(@PathVariable int id) {
        bservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	

}
