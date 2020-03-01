package com.bee.simplejdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bee.simplejdbc.repository.UserRepository;

// Rest Controller

@RestController
@RequestMapping(path="/hiveMind")
@CrossOrigin(origins = "*")
public class UserController {
	
	Bee bee = new Bee();
	
	//autowiring user repository
	@Autowired
	UserRepository userRepository;
	
	// Starting point
	@GetMapping
	public String check() {
		return "Welcome to Java Inspires";
	}
	
	// Get a list of all bee tags
	@GetMapping(path="/getBeeTags")
	public List<Bee> getAllBeeTags(){
		return userRepository.getAllBeeTags();
	}
	
	// Get a specific bee tag
	@GetMapping(path="/getBeeTags/{id}")
	public Bee getBeeTag(@PathVariable("id") String id){
		return userRepository.getBeeTag(id);
	}
	
	// Add another bee to db
	@PostMapping(path="/addNewBee")
	public int addNewBee(@RequestBody Bee bee){
		return userRepository.addNewBee(bee);
	}
	
	// Update a bee to db
	@PutMapping(path="/updateBee")
	public int updateBee(@RequestBody Bee bee){
		return userRepository.updateBee(bee);
	}
	
	
	
	// Remove a bee from db
	@DeleteMapping(path="/removeBee/{id}")
	public int removeBee(@PathVariable("id") String id){
		return userRepository.removeBee(id);
	}
}
