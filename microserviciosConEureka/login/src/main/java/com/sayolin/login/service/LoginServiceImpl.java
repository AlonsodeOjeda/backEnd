package com.sayolin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sayolin.login.facade.LoginFacade;
import com.sayolin.login.model.pojo.Login;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginFacade loginFacade;
	
	@Override
	public String ProcessLoginRequest(String email, String password) {
		
		Login log = loginFacade.getUser(email, password);
		
		System.out.println(log);
		
		if (log != null) {
			return "ok";
		}else {
			return "ko";
		}
	}	
}
