package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Movie {
	@JsonView(JsonModule.GetMovieListModule.class)
	private int id;
	@JsonView(JsonModule.GetMovieListModule.class)
	private String movieName;
	@JsonView(JsonModule.GetMovieListModule.class)
	private String url;
	@JsonView(JsonModule.GetMovieListModule.class)
	private String introduction;
	@JsonView(JsonModule.GetMovieListModule.class)
	private float score;
	@JsonView(JsonModule.GetMovieListModule.class)
	private long start_time;
	@JsonView(JsonModule.GetMovieListModule.class)
	private long end_time;
	
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
	public Movie(String movieName, String url, String introduction, float score, long start_time, long end_time) {
		super();
		this.movieName = movieName;
		this.url = url;
		this.introduction = introduction;
		this.score = score;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public Movie() {
		super();
	}
}
