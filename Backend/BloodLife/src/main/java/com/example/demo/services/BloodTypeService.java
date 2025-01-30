package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodType;
import com.example.demo.repositories.BloodTypeRepository;

@Service
public class BloodTypeService {
	
	@Autowired
	BloodTypeRepository btrepo;
	
	public List <BloodType> findAll() 
	{
		return btrepo.findAll();
	}
	
	public Optional <BloodType> findById(int id)
	{
		return btrepo.findById(id);
	}
	
	public BloodType save(BloodType bloodtype)
	{
		return btrepo.save(bloodtype);
	}
	
	public void deleteById(int id)
	{
		btrepo.deleteById(id);
	}

}
