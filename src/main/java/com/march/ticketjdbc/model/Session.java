package com.march.ticketjdbc.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonView;

public class Session {
	public interface SessionListModule {}
	@JsonView(SessionListModule.class)
	private int id;
	private int cinemaID;
	
	@JsonView(SessionListModule.class)
	private int hall;
	
	@JsonView(SessionListModule.class)
	private String movieName;
	
	@JsonView(SessionListModule.class)
	private Date start_time;
	
	@JsonView(SessionListModule.class)
	private Date end_time;
	
	@JsonView(SessionListModule.class)
	private String language;
	
	@JsonView(SessionListModule.class)
	private float price;
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
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Session(int id, int cinemaID, int hall, String movieName, Date start_time, Date end_time, String language,
			float price) {
		super();
		this.id = id;
		this.cinemaID = cinemaID;
		this.hall = hall;
		this.movieName = movieName;
		this.start_time = start_time;
		this.end_time = end_time;
		this.language = language;
		this.price = price;
	}
	public Session() {
		super();
	}
}
