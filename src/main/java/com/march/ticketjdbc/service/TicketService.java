package com.march.ticketjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.TicketDAOImpl;
import com.march.ticketjdbc.model.Ticket;

@Service
public class TicketService {
	@Autowired
	private TicketDAOImpl TicketDAO;
	
	public List<Ticket> findByOrderID(int orderID) {
		return TicketDAO.findByOrder(orderID);
	}
	public List<Ticket> findBySessionID(int sessionID) {
		return TicketDAO.findBySession(sessionID);
	}
	
}
