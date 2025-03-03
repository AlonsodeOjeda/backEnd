package com.sayolin.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sayolin.login.service.LoginService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
public class LoginController {
	private final LoginService service;
	
	@GetMapping("/login")
	public ResponseEntity<String> postUser(@RequestParam String email, @RequestParam String password) {
		
		//return "email:"+email+password;
		//*
		String result = service.ProcessLoginRequest(email, password);

		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().build();
		}//*/

	}
	
}