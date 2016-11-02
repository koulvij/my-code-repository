package com.vkoul.dao;

import com.vkoul.model.User;

public interface UserDao {
	User save(User account);
	User findByEmail(String email);

}
