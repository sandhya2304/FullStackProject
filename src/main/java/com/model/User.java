package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user123")
public class User
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private int experience;
	private String domain;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(String name, String email, int experience, String domain) {
		super();
		this.name = name;
		this.email = email;
		this.experience = experience;
		this.domain = domain;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	

}
