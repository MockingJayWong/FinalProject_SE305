package com.march.ticketjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.march.ticketjdbc.dao.*;
import com.march.ticketjdbc.model.*;

public class CinemaService {
	
	@Autowired
	MovieDAO movieDao;
	
	@Autowired
	cinemaDAO cinemaDao;
	
	@Autowired
	cinemaSessionDAO sessionDao;

	public Object findCinemasByMovie(int movieId) {
		List<Cinema> cinemas = new ArrayList<Cinema>();
		String name = movieDao.findByID(movieId).getMovieName();
		for (Session session:sessionDao.findByMovieName(name)) {
			cinemas.add(cinemaDao.findById(session.getCinemaID()));
		}
		return null;
	}
}
