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
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.findByID(id);
	}
	
	public int addMovie(Movie movie) {
		return movieDAO.insert(movie);
	}
}
