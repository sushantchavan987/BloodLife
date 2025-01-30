package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Donor;
import com.example.demo.services.DonorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/donors")
public class DonorController {
	
	@Autowired
	DonorService dservice;
	
	@GetMapping
	public List <Donor> getAllDonors()
	{
		return dservice.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Donor> getDonorById(@PathVariable int id)
	{
		return dservice.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	public Donor createDoctor(@RequestBody Donor donor)
	{
		return dservice.save(donor);
	}
	
	@PutMapping("{id}")
	public ResponseEntity <Donor> updateDonor(@PathVariable int id, @RequestBody Donor donor)
	{
		return dservice.findById(id)
				.map(existing -> {
					donor.setD_id(existing.getD_id());
					return ResponseEntity.ok(dservice.save(donor));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteDonor(@PathVariable int id) {
        dservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
