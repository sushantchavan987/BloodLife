package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository rrepo;
	
	public List <Role> getAllRoles() 
	{
		return rrepo.findAll();
	}
	
	public Role getRoleById(int id)
	{
		return rrepo.findById(id).get();
	}
	
	public Role saveRole(Role role)
	{
		return rrepo.save(role);
	}
	
	public void deleteRole(int id)
	{
		rrepo.deleteById(id);
	}

}
