package com.vkoul.dao;

import java.util.List;

import com.vkoul.model.User;

public interface UserDao {
	
	User save(User account);

	User findByEmail(String email);

	List<User> getAllUsers();

}
