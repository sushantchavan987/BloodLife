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

import com.example.demo.entities.Inventory;
import com.example.demo.services.InventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/inventories")
public class InventoryController {
	
	@Autowired 
	InventoryService iservice;
	
	@GetMapping
    public List <Inventory> getAllInventories() {
        return iservice.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity <Inventory> getInventoryById(@PathVariable int id) {
        return iservice.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } 
	
	@PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return iservice.save(inventory);
    }
	
	 @PutMapping("/{id}")
	 public ResponseEntity<Inventory> updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
	        return iservice.findById(id)
	                .map(existing -> {
	                    inventory.setInv_id(existing.getInv_id());
	                    return ResponseEntity.ok(iservice.save(inventory));
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInventory(@PathVariable int id) {
	        iservice.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
