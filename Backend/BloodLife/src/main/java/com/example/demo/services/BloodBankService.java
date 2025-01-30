package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodBank;
import com.example.demo.repositories.BloodBankRepository;

@Service
public class BloodBankService {
	
	@Autowired
	BloodBankRepository brepo;
	
    public List <BloodBank> findAll() {
        return brepo.findAll();
    }

    public Optional<BloodBank> findById(int id) {
        return brepo.findById(id);
    }

    public BloodBank save(BloodBank bloodBank) {
        return brepo.save(bloodBank);
    }

    public void deleteById(int id) {
        brepo.deleteById(id);
    }



}
