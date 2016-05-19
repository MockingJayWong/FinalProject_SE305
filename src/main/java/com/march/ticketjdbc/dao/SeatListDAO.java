package com.march.ticketjdbc.dao;

import java.sql.Date;
import java.util.Collection;

import com.march.ticketjdbc.model.Seat;

public interface SeatListDAO {
	public Collection<Seat> findAll();

	public Collection<Seat> findByCinemaIdAndHall(int cinemaID, int hall, Date time);

	public Seat findBySessionId(int sessionID);

	public Seat findById(int seatID);

	public int insert(Seat seat);

	public int update(Seat seat);

	public int delete(int seatID);
}
