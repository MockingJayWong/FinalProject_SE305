package com.example.dao;

import java.util.Collection;

import com.example.model.Ticket;



public interface TicketDAO {
	public Collection<Ticket> findAll();
	public Collection<Ticket> findByOrder(int orderID);
	public Collection<Ticket> findBySession(int sessionID);
	public int insert(Ticket ticket);
	public int update(Ticket ticket);
	public int delete(int ticketID);
}
