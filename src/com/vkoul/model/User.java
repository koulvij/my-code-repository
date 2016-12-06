package com.vkoul.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@javax.persistence.Entity
@Table(name = "user_cov")
@NamedQuery(name = User.FIND_BY_USERNAME, query = "select a from User a where a.name = :name")
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = -4606409120920127747L;
	public static final String FIND_BY_USERNAME = "User.findByUser";
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, length = 255, nullable = false)
	private String name;

	@Column(length = 80, nullable = false)
	@JsonIgnore
	private String password;

	//private Instant created;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles = new HashSet<String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> depatment = new HashSet<String>();
	

	
	protected User() {
		/* Reflection instantiation */
	}

	public User(String name, String passwordHash, Set<String> role, Set<String> depatment) {
		this.name = name;
		this.password = passwordHash;
		this.roles = role;
		this.depatment=depatment;
		//this.created = Instant.now();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<String> getDepatment() {
		return depatment;
	}
	
	public void setDepatment(Set<String> depatment) {
		this.depatment = depatment;
	}
	
	

//	public Instant getCreated() {
//		return created;
//	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}
	

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}