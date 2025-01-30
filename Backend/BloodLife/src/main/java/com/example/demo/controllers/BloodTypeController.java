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

import com.example.demo.entities.BloodType;
import com.example.demo.services.BloodTypeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bloodtype")
public class BloodTypeController {
	
	@Autowired
	BloodTypeService btservice;
	
	@GetMapping
	public List <BloodType> getAllBloodTypes() 
	{
		return btservice.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <BloodType> getBloodTypeById(@PathVariable int id)
	{
		return btservice.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public BloodType createBloodType(@RequestBody BloodType bloodtype)
	{
		return btservice.save(bloodtype);
	}
	
	@PutMapping("/{id}")
	 public ResponseEntity <BloodType> updateBloodType(@PathVariable int id, @RequestBody BloodType bloodtype)
	 {
		return btservice.findById(id)
				.map(existing -> {
					 bloodtype.setBloodtype_id(existing.getBloodtype_id());
					return ResponseEntity.ok(btservice.save(bloodtype));
				})
				.orElse(ResponseEntity.notFound().build());
	 }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBloodType(@PathVariable int id)
	{
		btservice.deleteById(id);
		return ResponseEntity.notFound().build();
	}

}
