package com.vkoul.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vkoul.model.User;



@Repository
@Transactional(readOnly = true)
public class UserDaoImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User save(User account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		entityManager.persist(account);
		return account;
	}
	
	public User findByUser(String email) {
		try {
			return entityManager.createNamedQuery(User.FIND_BY_USERNAME, User.class)
					.setParameter("name", email)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	
	public List<User> getAllUsers() {
		try {
			return entityManager.createQuery("from User", User.class).getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
