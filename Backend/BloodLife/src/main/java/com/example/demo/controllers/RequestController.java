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

import com.example.demo.entities.Request;
import com.example.demo.services.RequestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/requests")
public class RequestController {
	
	@Autowired
	RequestService rservice;
	
	@GetMapping
    public List <Request> getAllRequests() {
        return rservice.findAll();
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable int id) {
        return rservice.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return rservice.save(request);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable int id, @RequestBody Request request) {
        return rservice.findById(id)
                .map(existing -> {
                    request.setReq_id(existing.getReq_id());
                    return ResponseEntity.ok(rservice.save(request));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable int id) {
        rservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	

}
