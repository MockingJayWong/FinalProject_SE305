package com.march.ticketjdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.SeatListDAOImpl;
import com.march.ticketjdbc.model.Seat;



@Service
public class SeatService {
	
	@Autowired
	private SeatListDAOImpl seatListDAO;
	
	public Seat getSeatBySessionId(int sessionId) {
		return seatListDAO.findBySessionId(sessionId);
	}

}
