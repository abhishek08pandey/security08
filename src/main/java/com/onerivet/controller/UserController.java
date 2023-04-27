package com.onerivet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.User;
import com.onerivet.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/first")
	public String getFirst() {
		return "Welcome to 1Rivet";
	}
// Ask why add not work
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public String addUser(@RequestBody User user) {
		User save = userRepo.save(user);
		System.out.println(save);
		return "save";
	}
	
	@GetMapping("/get")
	@PreAuthorize("hasRole('USER')")
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	@GetMapping("/last")
	@PreAuthorize("hasRole('USER')")
	public String getLast() {
		return "last";
	}
	
	 @PostMapping("/new")
	    public ResponseEntity<User> create(@RequestBody User product) {
	        User savedProduct = userRepo.save(product);
	        URI productURI = URI.create("/products/" + savedProduct.getId());
	        System.out.println(productURI);
	        return ResponseEntity.created(productURI).body(savedProduct);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
/* Note:- 
 * In	 @EnableGlobleMethodSecurity(prePosttEnable=true)
 * 		@PreAuthorize("hasAuthority('ROLE_ADMIN')") on method
 * 		@PreAuthorize("hasRole('USER')")
 */
}
