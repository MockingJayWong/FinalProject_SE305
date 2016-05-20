package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.*;
import com.example.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDAOImpl movieDAO;
	
	public Collection<Movie> findAll() {
		if (movieDAO.findAll().size() == 0) {
			for (int i = 0; i < 10; i++) {
				Movie movie = new Movie("testMovie"+i, "p1.png", "This is testMovie"+i+", interesting...", 5+i);
				movieDAO.insert(movie);
			}
		}
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.findByID(id);
	}
	
	public int addMovie(Movie movie) {
		return movieDAO.insert(movie);
	}
}
