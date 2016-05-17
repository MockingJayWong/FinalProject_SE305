package com.example.JsonDatas;

public class OrderServiceJsonData {
	int orderId;
	String startTime;
	String endTime;
	String cinemaName;
	String []seats;
	float total;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String[] getSeats() {
		return seats;
	}
	public void setSeats(String[] seats) {
		this.seats = seats;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public OrderServiceJsonData() {
		super();
	}
	public OrderServiceJsonData(int orderId, String startTime, String endTime, String cinemaName, String[] seats,
			float total) {
		super();
		this.orderId = orderId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cinemaName = cinemaName;
		this.seats = seats;
		this.total = total;
	}
}
