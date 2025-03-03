package com.sayolin.login.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	private String nombre;
	
	private String eMail;
	
	private String password;
	
	private String edad;
		
}

