package com.example.model;

public class Cinema {
	private int id;
	private int cinemaID;
	private String cinemaName;
	private String address;
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
	public Cinema(int id, int cinemaID, String cinemaName, String address) {
		super();
		this.id = id;
		this.cinemaID = cinemaID;
		this.cinemaName = cinemaName;
		this.address = address;
	}
	public Cinema() {
		super();
	}
}
