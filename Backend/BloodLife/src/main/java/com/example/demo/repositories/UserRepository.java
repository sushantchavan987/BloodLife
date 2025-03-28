package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUname(String uname);
	List<User> findAllByUname(String uname);

}
