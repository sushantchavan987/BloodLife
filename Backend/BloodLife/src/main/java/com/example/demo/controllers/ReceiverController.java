package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Receiver;
import com.example.demo.services.ReceiverService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/receivers")
public class ReceiverController {
	
	@Autowired
	ReceiverService rservice;
	
	@GetMapping
	public List <Receiver> getAllReceivers()
	{
		return rservice.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Receiver> getRecieverById(@PathVariable int id)
	{
		return rservice.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Receiver createReceiver(@RequestBody Receiver receiver)
	{
        return rservice.save(receiver);
    }
	
	@PostMapping("{id}")
	public ResponseEntity <Receiver> updateReceiver(@PathVariable int id, @RequestBody Receiver reciever)
	{
		return rservice.findById(id)
				.map(existing -> {
					reciever.setR_id(existing.getR_id());
					return ResponseEntity.ok(rservice.save(reciever));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceiver(@PathVariable int id) {
        rservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
