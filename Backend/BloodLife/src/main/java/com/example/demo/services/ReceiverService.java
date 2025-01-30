package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Receiver;
import com.example.demo.repositories.ReceiverRepository;

@Service
public class ReceiverService {
	
	@Autowired
	ReceiverRepository rrepo;
	
	public List <Receiver> findAll()
	{
		return rrepo.findAll();
	}
	
	public Optional <Receiver> findById(int id)
	{
		return rrepo.findById(id);
	}
	
	public Receiver save(Receiver receiver)
	{
		return rrepo.save(receiver);
	}
	
	public void deleteById(int id)
	{
		rrepo.deleteById(id);
	}

}
