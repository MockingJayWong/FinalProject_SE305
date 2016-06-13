package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Session {

	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class, JsonModule.GetMovieByCinemaIdModule.class})
	private int id;
	
	private int cinemaID;
	
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class,JsonModule.GetOrderDetailModule.class, JsonModule.GetMovieByCinemaIdModule.class})
	private int hall;
	
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class, JsonModule.GetOrderDetailModule.class})
	private String movieName;
	
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class,JsonModule.GetOrderDetailModule.class, JsonModule.GetMovieByCinemaIdModule.class})
	private long start_time;
	
	@JsonView({JsonModule.GetSessionListModule.class,  JsonModule.GetCinemaListModule.class,JsonModule.GetOrderDetailModule.class, JsonModule.GetMovieByCinemaIdModule.class})
	private long end_time;
	
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class,JsonModule.GetOrderDetailModule.class, JsonModule.GetMovieByCinemaIdModule.class})
	private String language;
	
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.GetCinemaListModule.class, JsonModule.GetMovieByCinemaIdModule.class})
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
	public long getStart_time() {
		return start_time;
	}
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
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
	public Session(int cinemaID, int hall, String movieName, long start_time, long end_time, String language,
			float price) {
		super();
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
