package com.sayolin.login.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sayolin.login.model.pojo.Login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginFacade {
	
	@Value("${getUser.url}")
	private String getUserUrl;
	
	private final RestTemplate restTemplate;
	
	public Login getUser(String email, String password) {
		
		
		//return String.format(getUserUrl + "?email=%s" + "&password=%s" ,email,password);
		try {
			 Login log = restTemplate.getForObject(String.format(getUserUrl + "?email=%s" + "&password=%s" ,email,password), Login.class);
			//Login log = restTemplate.getForObject("http://ms-users/users?email=mail&password=12", Login.class);			
			return log;
			 
		} catch (HttpClientErrorException e) {
			return null;
		}
	}
}
