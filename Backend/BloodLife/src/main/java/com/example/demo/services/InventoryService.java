package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inventory;
import com.example.demo.repositories.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository irepo;
	
    public List <Inventory> findAll() {
        return irepo.findAll();
    }

    public Optional<Inventory> findById(int id) {
        return irepo.findById(id);
    }

    public Inventory save(Inventory inventory) {
        return irepo.save(inventory);
    }

    public void deleteById(int id) {
        irepo.deleteById(id);
    }

}
