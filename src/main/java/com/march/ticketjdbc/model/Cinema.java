package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;


public class Cinema {
	public interface CinemaModule {}
	
	@JsonView(CinemaModule.class)
	private int id;
	@JsonView(CinemaModule.class)
	private String cinemaName;
	@JsonView(CinemaModule.class)
	private String address;
	
	private String password;
	private String telephone;
	private String email;
	
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
	
	public Cinema(int id, String cinemaName, String address, String password, String telephone, String email) {
		super();
		this.id = id;
		this.cinemaName = cinemaName;
		this.address = address;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
	}
	public Cinema() {
		super();
	}
}
