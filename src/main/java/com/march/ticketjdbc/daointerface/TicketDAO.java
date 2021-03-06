package com.march.ticketjdbc.daointerface;

import java.util.List;

import com.march.ticketjdbc.model.Ticket;



public interface TicketDAO {
	public List<Ticket> findAll();
	public List<Ticket> findByOrder(int orderID);
	public List<Ticket> findBySession(int sessionID);
	public int insert(Ticket ticket);
	public int update(Ticket ticket);
	public int delete(int ticketID);
	public int deleteByOrderID(int orderID);
}
