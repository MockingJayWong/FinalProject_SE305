package com.march.ticketjdbc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.*;
import com.march.ticketjdbc.model.*;

@Service
public class MovieService {

	@Autowired
	MovieDAOImpl movieDAO;
	
	@Autowired
	CinemaDAOImpl cinemaDAO;
	
	@Autowired
	SessionDAOImpl sessionDao;

	public List<Movie> findAll() {
		return movieDAO.findAll();
	}

	public Movie find(int id) {
		return movieDAO.findByID(id);
	}
	
	public List<Movie> findMovieByCinemaId(int cinemaId) {
		List<Movie> movies = new ArrayList<Movie>();
		Cinema cinema = cinemaDAO.findById(cinemaId);
		
		List<Session> sessionList = sessionDao.findByCinemaID(cinemaId);
		
		if (cinema != null) {
			for (int i = 0; i < sessionList.size(); i++) {
				Session session = sessionList.get(i);
				Movie movie = movieDAO.findByMovieName(session.getMovieName());
				movies.add(movie);
			}
		}
		
		return movies;
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
