package com.vkoul.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "roles_master")

public class RoleMaster {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, length = 255, nullable = false)
	private String name;

	@Column(length = 255)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleMaster [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	

}