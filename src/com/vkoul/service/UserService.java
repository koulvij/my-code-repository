package com.vkoul.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.vkoul.model.User;

public interface UserService {
	
	/**
	 * @param account
	 */
	void signin(User account);

	/**
	 * @param createAccount
	 * @return
	 */
	User save(User createAccount);

	/**
	 * @param name
	 * @return
	 */
	User findByUser(String name);

	/**
	 * @param username
	 * @return
	 */
	UserDetails loadUserByUsername(String username);
	
	/**
	 * @return
	 */
	List<User> getAllUsers();

}
