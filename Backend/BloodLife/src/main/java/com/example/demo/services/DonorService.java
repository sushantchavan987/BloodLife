package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Donor;
import com.example.demo.repositories.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	DonorRepository drepo;
	
	public List <Donor> findAll()
	{
		return drepo.findAll();
	}
	
	public Optional <Donor> findById(int id)
	{
		return drepo.findById(id);
	}
	
	public Donor save(Donor donor)
	{
		return drepo.save(donor);
	}
	
	public void deleteById(int id)
	{
		drepo.deleteById(id);
	}

}
