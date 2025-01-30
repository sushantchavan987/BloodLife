package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
