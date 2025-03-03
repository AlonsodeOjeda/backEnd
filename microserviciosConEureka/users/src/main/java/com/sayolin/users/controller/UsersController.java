package com.sayolin.users.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sayolin.users.model.pojo.User;
import com.sayolin.users.model.request.CreateUserRequest;
import com.sayolin.users.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {
	private final UsersService service;
	/*
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = service.getUsers();
		
		if(users != null) {
			return ResponseEntity.ok(users);
		}else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	*/
	/*@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = service.getUser(userId);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}*/
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId){
		Boolean deleted = service.removeUser(userId);
		if(Boolean.TRUE.equals(deleted)) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> postUser(@RequestBody CreateUserRequest	request) {
		User createdUser = service.createUser(request);
		System.out.println("Pase por postUser");
		if (createdUser != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<User> getUserPassord (@RequestParam String email, @RequestParam String password){
			
		User user = service.getLogin(email,password);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
}
