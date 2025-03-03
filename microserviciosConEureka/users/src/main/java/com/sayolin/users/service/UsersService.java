package com.sayolin.users.service;

import java.util.List;

import com.sayolin.users.model.pojo.User;
import com.sayolin.users.model.request.CreateUserRequest;

public interface UsersService {
	List<User> getUsers();
	User getUser(String userId);
	Boolean removeUser(String userId);
	User createUser(CreateUserRequest request);
	User getLogin(String email, String password);
}
