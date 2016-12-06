package com.vkoul.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vkoul.dao.UserDaoImpl;
import com.vkoul.model.User;

@Service("userService")
public class UserServiceImpl implements UserDetailsService,UserService  {

	@Autowired
	private UserDaoImpl userDao;

/*	@PostConstruct
	protected void initialize() {
		userDao.save(new Account("user", "demo", "ROLE_USER"));
		userDao.save(new Account("admin", "admin", "ROLE_ADMIN"));
	}*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User account = userDao.findByUser(username);
		if (account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}

	public void signin(User account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}

	private Authentication authenticate(User account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null,
				Collections.singleton(createAuthority(account)));
	}

	private org.springframework.security.core.userdetails.User createUser(User account) {
		return new org.springframework.security.core.userdetails.User(account.getName(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(User account) {
			Map<String, Boolean> roles = new HashMap<String, Boolean>();
			for (GrantedAuthority authority : account.getAuthorities()) {
				roles.put(authority.getAuthority(), Boolean.TRUE);
			}
		return new SimpleGrantedAuthority(roles.toString());
	}
	
	@Override
	public User findByUser(String email) {
		return userDao.findByUser(email);
	}

	@Override
	public User save(User createAccount) {
		return userDao.save(createAccount);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
