package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	@JsonView(JsonModule.UserModule.class)
	private int id;
	@JsonView(JsonModule.UserModule.class)
	private String username;
	@JsonView(JsonModule.UserModule.class)
	private String password;
	@JsonView(JsonModule.UserModule.class)
	private String telephone;
	@JsonView(JsonModule.UserModule.class)
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String username, String password, String telephone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
	}
	public User() {
		super();
	}
}
