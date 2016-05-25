package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Orders {
	
	@JsonView(JsonModule.CreateOrderModule.class)
	private int id;
	@JsonView(JsonModule.CreateOrderModule.class)
	private int userID;
	@JsonView(JsonModule.CreateOrderModule.class)
	private int cinemaID;
	@JsonView(JsonModule.CreateOrderModule.class)
	private long time;
	@JsonView(JsonModule.CreateOrderModule.class)
	private float prices;
	
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Orders(int userID, int cinemaID, long time, float prices, String state) {
		super();
		this.userID = userID;
		this.cinemaID = cinemaID;
		this.time = time;
		this.prices = prices;
		this.state = state;
	}
	public Orders() {
		super();
	}
}
