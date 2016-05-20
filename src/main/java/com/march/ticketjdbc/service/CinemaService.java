package com.march.ticketjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.dao.*;
import com.march.ticketjdbc.daointerface.CinemaDAO;
import com.march.ticketjdbc.daointerface.MovieDAO;
import com.march.ticketjdbc.daointerface.SessionDAO;
import com.march.ticketjdbc.model.*;

@Service
public class CinemaService {

	@Autowired
	MovieDAOImpl movieDAO;
	
	@Autowired
	CinemaDAOImpl cinemaDAO;
	
	@Autowired
	SessionDAOImpl sessionDao;

	public List<Cinema> findCinemasByMovie(int movieId) {
		List<Cinema> cinemas = new ArrayList<Cinema>();
		String name = movieDAO.findByID(movieId).getMovieName();
		for (Session session:sessionDao.findByMovieName(name)) {
			cinemas.add(cinemaDAO.findById(session.getCinemaID()));
		}

		return cinemas;
	}
}
