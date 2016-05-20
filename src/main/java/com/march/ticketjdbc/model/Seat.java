package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Seat {
	public interface SessionInfoModule{}
	public interface OrderInfoModule{}
	public interface SessionOrderModule extends SessionInfoModule, OrderInfoModule{}
	private int id;
	private int sessionID;
	
	@JsonView(SessionOrderModule.class)
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
