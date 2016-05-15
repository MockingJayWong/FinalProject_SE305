package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.*;
import com.example.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;
	
	public Collection<Movie> findAll() {
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.find(id);
	}
	
	public int addMovie(Movie movie) {
		return movieDAO.addMovie(movie);
	}
}
