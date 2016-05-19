package com.march.ticketjdbc.dao;

import java.util.Collection;

import com.march.ticketjdbc.model.Movie;

public interface MovieDAO {
	public Collection<Movie> findAll();

	public Movie findByID(int id);
	
	//public Collection<Movie> findByTime(Date StartTime)
	
	public Movie findByMovieName(String name);

	public int insert(Movie movie);
	
	public int update(Movie movie);
	
	public int delete(int movieID);
}
