package com.example.dao;

import java.util.Collection;

import com.example.model.Seat;



public interface SeatListDAO {
	public Collection<Seat> findAll();
	
	
	public Seat findByCinemaIdAndHall(int cinemaID,int hall);
	public Seat findBySessionId(int sessionID);
	public Seat findById(int seatID);
	
	public int insert(Seat seat);
	public int update(Seat seat);
	public int delete(int seatID);
}
