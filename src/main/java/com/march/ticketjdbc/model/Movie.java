package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Movie {
	@JsonIgnore
	private int id;
	private String movieName;
	private String url;
	private String introduction;
	private float score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public float getScore() {
		return score;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	public Movie(int id, String movieName, String url, String introduction, float score) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.url = url;
		this.introduction = introduction;
		this.score = score;
	}
	public Movie() {
		super();
	}
}
