package com.march.ticketjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.SessionDAOImpl;
import com.march.ticketjdbc.model.Session;



@Service
public class SessionService {
	
	@Autowired
	private SessionDAOImpl sessionDAO;
	
	public Session getSessionDetailed(int sessionId) {
		return sessionDAO.findByID(sessionId);
	}
	
	public List<Session> findSessionsByMovieAndCinema(int cinemaId, String movieName) {
		return sessionDAO.findByCinemaIdAndMovieName(cinemaId, movieName);
	}

}
