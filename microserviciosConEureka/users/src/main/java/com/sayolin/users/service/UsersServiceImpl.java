package com.sayolin.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sayolin.users.data.UserRepository;
import com.sayolin.users.model.pojo.User;
import com.sayolin.users.model.request.CreateUserRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getUsers() {
		List<User> users = repository.findAll();
		return users.isEmpty() ? null : users;
	}

	@Override
	public User getUser(String userId) {
		return repository.findById(Long.valueOf(userId)).orElse(null);
		
	}

	@Override
	public Boolean removeUser(String userId) {
		User user = repository.findById(Long.valueOf(userId)).orElse(null);
		if (user != null) {
			repository.delete(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	@Override
	public User createUser(CreateUserRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getNombre().trim())
				&& StringUtils.hasLength(request.getEmail().trim())
				&& StringUtils.hasLength(request.getPassword().trim())
				&& request.getEdad() > 18) {
			User user = User.builder().nombre(request.getNombre())
									  .email(request.getEmail())
									  .edad(request.getEdad())
									  .password(request.getPassword())
									  .build();
			return repository.save(user);
		} else {
			return null;
		}
	}


	@Override
	public User getLogin(String email, String password) {
		User user =repository.findByEmailAndPassword(String.valueOf(email),String.valueOf(password));
		
		if(user != null) {
			return user;
		}else {
			return null;
			
		}
		
	}//*/
	
}
