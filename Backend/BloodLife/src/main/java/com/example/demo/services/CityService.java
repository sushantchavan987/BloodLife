package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.City;
import com.example.demo.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository crepo;
	
	public List <City> getAllCities()
	{
		return crepo.findAll();
	}
	
	public City getCityById(int id)
	{
		return crepo.findById(id).get();
	}
	
	public City createCity(City city)
	{
		return crepo.save(city);
	}
	
	public City updateCity(int id, City cityDetails)
	{
		City city = getCityById(id);
		city.setCname(cityDetails.getCname());
		return crepo.save(city);
	}
	
	public void deleteCity(int id)
	{
		crepo.deleteById(id);
	}

}