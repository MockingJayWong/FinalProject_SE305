package com.march.ticketjdbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.dao.*;
import com.march.ticketjdbc.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDAOImpl movieDAO;

	public Collection<Movie> findAll() {
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.findByID(id);
	}
	
	public int addMovie(Movie movie) {
		return movieDAO.insert(movie);
	}
	
	public int deleteMovie(int movieID) {
		return movieDAO.delete(movieID);
	}
}
