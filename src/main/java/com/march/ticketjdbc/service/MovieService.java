package com.march.ticketjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.*;
import com.march.ticketjdbc.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDAOImpl movieDAO;

	public List<Movie> findAll() {
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.findByID(id);
	}

	public Movie addMovie(Movie movie) {
		movie.setId(movieDAO.insert(movie));
		return movie;
	}

	public int deleteMovie(int movieID) {
		return movieDAO.delete(movieID);
	}
	
	public int updateMovie(Movie movie){
		return movieDAO.update(movie);
	}
}
