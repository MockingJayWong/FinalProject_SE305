package com.march.ticketjdbc.daointerface;

import java.sql.Date;
import java.util.List;

import com.march.ticketjdbc.model.Seat;

public interface SeatListDAO {
	public List<Seat> findAll();

	public List<Seat> findByCinemaIdAndHall(int cinemaID, int hall, Date time);

	public Seat findBySessionId(int sessionID);

	public Seat findById(int seatID);

	public int insert(Seat seat);

	public int update(Seat seat);

	public int delete(int seatID);
}
