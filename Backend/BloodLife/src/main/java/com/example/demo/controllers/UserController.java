package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodBank;
import com.example.demo.entities.BloodType;
import com.example.demo.entities.City;
import com.example.demo.entities.DemoUser;
import com.example.demo.entities.Donor;
import com.example.demo.entities.Receiver;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.BloodBankRepository;
import com.example.demo.repositories.BloodTypeRepository;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.DonorRepository;
import com.example.demo.repositories.ReceiverRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	CityRepository crepo;
	
	@Autowired
	BloodBankRepository brepo;
	
	@Autowired
	DonorRepository drepo;
	
	@Autowired
	ReceiverRepository recrepo;
	
	@Autowired
	BloodTypeRepository btrepo;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return uservice.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id)
	{
		return ResponseEntity.ok(uservice.getUserById(id));
	}
	
	@PostMapping("/registration")
	public ResponseEntity<?> createUser(@RequestBody DemoUser user) {
	    try {
	        // Debug log: Input received
	        System.out.println("Received user payload: " + user);

	        // Validate Role ID
	        if (user.getRole() == null || user.getRole() <= 0) {
	            throw new RuntimeException("Invalid role ID: " + user.getRole());
	        }

	        // Validate City ID
	        if (user.getCityId() == null || user.getCityId() <= 0) {
	            throw new RuntimeException("Invalid city ID: " + user.getCityId());
	        }

	        // Fetch Role and City from database
	        Role role = rrepo.findById(user.getRole())
	                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + user.getRole()));
	        City city = crepo.findById(user.getCityId())
	                .orElseThrow(() -> new RuntimeException("City not found with ID: " + user.getCityId()));

	        // Validate required user fields
	        if (user.getAddress() == null || user.getAddress().isEmpty()) {
	            throw new RuntimeException("Address is required.");
	        }
	        if (user.getPassword() == null || user.getPassword().isEmpty()) {
	            throw new RuntimeException("Password is required.");
	        }
	        if (user.getContact() == null || user.getContact().isEmpty()) {
	            throw new RuntimeException("Contact is required.");
	        }

	        // Create and save User
	        User newUser = new User();
	        newUser.setAddress(user.getAddress());
	        newUser.setRole(role);
	        newUser.setCity(city);
	        newUser.setPassword(user.getPassword());
	        newUser.setContact(user.getContact());
	        newUser.setUname(user.getName()); // Set uname from the payload 'name'
	        User savedUser = uservice.createUser(newUser);
	        System.out.println("User successfully created with ID: " + savedUser.getUid());

	        // Handle Donor role
	        if (role.getR_name().equalsIgnoreCase("Donor") && user.getDonorDetails() != null) {
	            Donor donor = new Donor();
	            donor.setDname(user.getDonorDetails().getDname());
	            donor.setAge(user.getDonorDetails().getAge());
	            donor.setGender(user.getDonorDetails().getGender());
	            donor.setMedical_history(user.getDonorDetails().getMedicalHistory());
	            donor.setUser(savedUser);

	            // Fetch and set BloodType
	            BloodType bloodType = btrepo.findById(user.getDonorDetails().getBloodTypeId())
	                    .orElseThrow(() -> new RuntimeException("Blood type not found with ID: " + user.getDonorDetails().getBloodTypeId()));
	            donor.setBloodtype(bloodType);

	            // Save Donor
	            Donor savedDonor = drepo.save(donor);
	            System.out.println("Donor successfully saved: " + savedDonor);
	        }

	        // Handle Receiver role
	        if (role.getR_name().equalsIgnoreCase("Receiver") && user.getReceiverDetails() != null) {
	            Receiver receiver = new Receiver();
	            receiver.setR_name(user.getReceiverDetails().getR_name());
	            receiver.setAge(user.getReceiverDetails().getAge());
	            receiver.setGender(user.getReceiverDetails().getGender());
	            receiver.setUser(savedUser);

	            // Fetch and set BloodType
	            BloodType bloodType = btrepo.findById(user.getReceiverDetails().getBloodTypeId())
	                    .orElseThrow(() -> new RuntimeException("Blood type not found with ID: " + user.getReceiverDetails().getBloodTypeId()));
	            receiver.setBloodtype(bloodType);

	            // Save Receiver
	            Receiver savedReceiver = recrepo.save(receiver);
	            System.out.println("Receiver successfully saved: " + savedReceiver);
	        }

	        // Handle BloodBank role
	        if (role.getR_name().equalsIgnoreCase("BloodBank") && user.getBloodBankDetails() != null) {
	            BloodBank bloodBank = new BloodBank();
	            bloodBank.setBname(user.getBloodBankDetails().getBname());
	            bloodBank.setReg_no(user.getBloodBankDetails().getReg_no());
	            bloodBank.setUser(savedUser);

	            // Save BloodBank
	            BloodBank savedBloodBank = brepo.save(bloodBank);
	            System.out.println("BloodBank successfully saved: " + savedBloodBank);
	        }

	        // Return success response
	        return ResponseEntity.ok("Registration successful!");
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the error for debugging
	        String errorMessage = e.getMessage();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + errorMessage);
	    }
	}


	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody DemoUser loginRequest) {
	    try {
	        // Fetch users with the given username
	        List<User> users = uservice.findAllByUsername(loginRequest.getName());

	        if (users.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found. Please register.");
	        }

	        if (users.size() > 1) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("Multiple users found with the same username. Contact support.");
	        }

	        User user = users.get(0);

	        // Compare passwords (assuming plain text for now)
	        if (loginRequest.getPassword().equals(user.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
	}



	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user)
	{
		return ResponseEntity.ok(uservice.updateUser(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		uservice.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully");
	}
	
}	
