package com.example.model;

public class Seat {
	private int id;
	private int sessionID;
	private String sold_list;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public String getSold_list() {
		return sold_list;
	}
	public void setSold_list(String sold_list) {
		this.sold_list = sold_list;
	}
	public Seat(int id, int sessionID, String sold_list) {
		super();
		this.id = id;
		this.sessionID = sessionID;
		this.sold_list = sold_list;
	}
	public Seat() {
		super();
	}
}
