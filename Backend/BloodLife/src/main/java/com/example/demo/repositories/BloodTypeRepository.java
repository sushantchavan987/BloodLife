package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BloodType;

public interface BloodTypeRepository extends JpaRepository<BloodType, Integer> {

}
