package com.march.ticketjdbc.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonView;

public class Orders {
	
	@JsonView(JsonModule.CreateOrderModule.class)
	private int id;
	@JsonView(JsonModule.CreateOrderModule.class)
	private int userID;
	@JsonView(JsonModule.CreateOrderModule.class)
	private int cinemaID;
	@JsonView(JsonModule.CreateOrderModule.class)
	private Long time;
	@JsonView(JsonModule.CreateOrderModule.class)
	private float prices;
	
	private OrderState state;
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
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public Orders(int userID, int cinemaID, Long time, float prices, OrderState state) {
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
