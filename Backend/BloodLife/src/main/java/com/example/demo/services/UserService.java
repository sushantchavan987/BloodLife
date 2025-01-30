package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository urepo;
	
	public List<User> getAllUsers()
	{
		return urepo.findAll();
	}
	
	public User getUserById(int id)
	{
		return urepo.findById(id).get();
	}
	
	public User createUser(User user)
	{
		return urepo.save(user);
	}
	
	public User updateUser(int id, User userDetails)
	{
		User user = getUserById(id);
		user.setUname(userDetails.getUname());
		user.setPassword(userDetails.getPassword());
		user.setContact(userDetails.getContact());
		user.setAddress(userDetails.getAddress());
		user.setCity(userDetails.getCity());
		user.setRole(userDetails.getRole());
		return urepo.save(user);
	}
	
	public void deleteUser(int id)
	{
		urepo.deleteById(id);
	}
	
	public User findByUsername(String username) {
        // Implement database logic to find user by username
        return urepo.findByUname(username);
    }
	
	 public List<User> findAllByUsername(String uname) {
	        return urepo.findAllByUname(uname);
	    }
}
