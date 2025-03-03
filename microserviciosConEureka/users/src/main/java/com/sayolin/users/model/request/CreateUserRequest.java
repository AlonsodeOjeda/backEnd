package com.sayolin.users.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserRequest {
	
	private String nombre;
	private String email;
	private String password;
	private int edad;

}
