package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.City;
import com.example.demo.services.CityService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	CityService cservice;
	
	@GetMapping
	public List <City> getAllCities()
	{
		return cservice.getAllCities();
	}
	
	@GetMapping("/{id}")
	public City getCityById(@PathVariable int id)
	{
		return cservice.getCityById(id);
	}
	
	@PostMapping
	public City createCity(@RequestBody City city)
	{
		return cservice.createCity(city);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCity(@PathVariable int id)
	{
		cservice.deleteCity(id);
	}
	
	
}
