package com.march.ticketjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.march.ticketjdbc.dao.*;
import com.march.ticketjdbc.model.*;

public class CinemaService {

	@Autowired
	MovieDAO movieDAO;
	
	@Autowired
	CinemaDAO cinemaDAO;
	
	@Autowired
	SessionDAO sessionDao;

	public List<Cinema> findCinemasByMovie(int movieId) {
		List<Cinema> cinemas = new ArrayList<Cinema>();
		String name = movieDAO.findByID(movieId).getMovieName();
		for (Session session:sessionDao.findByMovieName(name)) {
			cinemas.add(cinemaDAO.findById(session.getCinemaID()));
		}

		return cinemas;
	}
}
