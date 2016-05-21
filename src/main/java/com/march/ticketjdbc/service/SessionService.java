package com.march.ticketjdbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.dao.SessionDAOImpl;
import com.march.ticketjdbc.model.Session;



@Service
public class SessionService {
	
	@Autowired
	private SessionDAOImpl sessionDAO;
	
	public Session getSessionDetailed(int sessionId) {
		return sessionDAO.findByID(sessionId);
	}
	
	public Collection<Session> findSessionsByMovieAndCinema( int cinemaId, String movieName) {
		return sessionDAO.findByCinemaIdAndMovieName(cinemaId, movieName);
	}

}
