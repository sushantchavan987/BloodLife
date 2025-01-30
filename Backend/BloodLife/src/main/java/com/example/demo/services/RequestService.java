package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Request;
import com.example.demo.repositories.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
	RequestRepository rrepo;
	
	public List <Request> findAll() {
        return rrepo.findAll();
    }

    public Optional <Request> findById(int id) {
        return rrepo.findById(id);
    }

    public Request save(Request request) {
        return rrepo.save(request);
    }

    public void deleteById(int id) {
        rrepo.deleteById(id);
    }

}
