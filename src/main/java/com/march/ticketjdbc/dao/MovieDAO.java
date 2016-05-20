package com.march.ticketjdbc.dao;

import java.util.List;

import com.march.ticketjdbc.model.Movie;

public interface MovieDAO {
	public List<Movie> findAll();

	public Movie findByID(int id);
	
	//public List<Movie> findByTime(Date StartTime)
	
	public Movie findByMovieName(String name);

	public int insert(Movie movie);
	
	public int update(Movie movie);
	
	public int delete(int movieID);
}
