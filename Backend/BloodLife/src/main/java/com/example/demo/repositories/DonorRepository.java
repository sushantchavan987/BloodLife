package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

}
