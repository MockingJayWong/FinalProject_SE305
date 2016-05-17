package com.example.model;

public class Cinema {
	private int id;
	private int cinemaID;
	private String cinemaName;
	private String address;
	
	private String username;
	private String password;
	private String telephone;
	private String email;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Cinema(String cinemaName, String address, String username, String password,
			String telephone, String email) {
		super();
		this.cinemaName = cinemaName;
		this.address = address;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
	}
	public Cinema() {
		super();
	}
}
