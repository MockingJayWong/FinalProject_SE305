package com.march.ticketjdbc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Cinema {
	@JsonView({JsonModule.GetCinemaListModule.class})
	private int id;
	@JsonView({JsonModule.GetCinemaListModule.class, JsonModule.CinemaModule.class,JsonModule.GetOrderDetailModule.class})
	private String cinemaName;
	@JsonView({JsonModule.GetCinemaListModule.class, JsonModule.CinemaModule.class,JsonModule.GetOrderDetailModule.class})
	private String address;
	
	//@JsonView(JsonModule.CinemaModule.class)
	private String username;
	//@JsonView(JsonModule.CinemaModule.class)
	private String password;
	@JsonView(JsonModule.CinemaModule.class)
	private String telephone;
	//@JsonView(JsonModule.CinemaModule.class)
	private String email;
	
	@JsonView(JsonModule.GetCinemaListModule.class)
	private List<Session> sessions;
	
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
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
	public Cinema(String cinemaName, String address) {
		super();
		this.cinemaName = cinemaName;
		this.address = address;
		//this.sessions = new ArrayList<Session>();
	}
	
	public Cinema(String cinemaName, String address, String username, String password, String telephone, String email) {
		super();
		this.cinemaName = cinemaName;
		this.address = address;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		//this.sessions = new ArrayList<Session>();
	}
	public Cinema() {
		super();
		//this.sessions = new ArrayList<Session>();
	}
}
