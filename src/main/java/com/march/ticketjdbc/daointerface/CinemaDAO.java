package com.march.ticketjdbc.daointerface;

import java.util.List;

import com.march.ticketjdbc.model.Cinema;



public interface CinemaDAO {
	public List<Cinema> findAll();
	public Cinema findByCinemaName(String cinemaName);
	public Cinema findByUserName(String userName);
	public Cinema findById(int cinemaID);
	public int insert(Cinema cinema);
	public int update(Cinema cinema);
	public int delete(int cinemaID);
}
