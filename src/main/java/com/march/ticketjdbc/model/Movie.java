package com.march.ticketjdbc.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Movie {
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetMovieDetailModule.class})
	private int id;
	
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetMovieDetailModule.class})
	private String movieName;
	
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetMovieDetailModule.class})
	private String url;
	
	@JsonView(JsonModule.GetMovieDetailModule.class)
	private String type;
	
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetMovieDetailModule.class})
	private String introduction;
	
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetMovieDetailModule.class})
	private float score;
	
	private long start_time;
	
	private long end_time;
	
	@JsonView(JsonModule.GetMovieDetailModule.class)
	private long length;
	
	@JsonView(JsonModule.GetMovieDetailModule.class)
	private String director;
	
	@JsonView(JsonModule.GetMovieDetailModule.class)
	private String actor;
	
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
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
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}

	public Movie(String movieName, String url, String type, String introduction, float score, long start_time,
			long end_time, long length, String director, String actor) {
		super();
		this.movieName = movieName;
		this.url = url;
		this.type = type;
		this.introduction = introduction;
		this.score = score;
		this.start_time = start_time;
		this.end_time = end_time;
		this.length = length;
		this.director = director;
		this.actor = actor;
	}
	public Movie() {
		super();
	}
}
