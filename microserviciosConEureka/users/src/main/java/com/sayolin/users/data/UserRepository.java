package com.sayolin.users.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayolin.users.model.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByNombre(String nombre);
	User findByEmailAndPassword(String email, String paswword);
}
