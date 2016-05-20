package com.march.ticketjdbc.dao;

import java.util.List;

import com.march.ticketjdbc.model.Cinema;



public interface CinemaDAO {
	public List<Cinema> findAll();
	public Cinema findByName(String userName);
	public Cinema findById(int cinemaID);
	public int insert(Cinema cinema);
	public int update(Cinema cinema);
	public int delete(int cinemaID);
}
