package com.example.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String telephone;
	private String email;
	private UserType role;
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
	public UserType getRole() {
		return role;
	}
	public void setRole(UserType role) {
		this.role = role;
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
