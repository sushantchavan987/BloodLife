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

import com.example.demo.entities.BloodBank;
import com.example.demo.services.BloodBankService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/blood-banks")
public class BloodBankController {
	
	@Autowired
	BloodBankService bservice;
	
	@GetMapping
    public List <BloodBank> getAllBloodBanks() {
        return bservice.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<BloodBank> getBloodBankById(@PathVariable int id) {
        return bservice.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
	public BloodBank createBloodBank(@RequestBody BloodBank bloodbank) {
        return bservice.save(bloodbank);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity <BloodBank> updateBloodBank(@PathVariable int id, @RequestBody BloodBank bloodbank)
    {
    	return bservice.findById(id)
    			.map(existing -> {
    				bloodbank.setBid(existing.getBid());
    				return ResponseEntity.ok(bservice.save(bloodbank));
    			})
    			.orElse(ResponseEntity.notFound().build());
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodBank(@PathVariable int id) {
        bservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	

}
