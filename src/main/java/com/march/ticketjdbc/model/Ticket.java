package com.march.ticketjdbc.model;

public class Ticket implements Comparable{
	private int id;
	private int orderID;
	private int seat;
	private float price;
	private int sessionID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public Ticket(int orderID, int seat, float price, int sessionID) {
		super();
		this.orderID = orderID;
		this.seat = seat;
		this.price = price;
		this.sessionID = sessionID;
	}
	public Ticket() {
		super();
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Ticket other = (Ticket)o;
		Integer seat = this.seat;
		Integer ohter_seat = other.getSeat();
		return seat.compareTo(ohter_seat);
	}
}
