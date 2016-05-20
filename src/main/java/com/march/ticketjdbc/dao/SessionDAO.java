package com.march.ticketjdbc.dao;

import java.sql.Date;
import java.util.List;

import com.march.ticketjdbc.model.Session;


public interface SessionDAO {
	public List<Session> findAll();

	public Session findByID(int SessionId);
	public List<Session> findByCinemeIdAndHall(int cinemaID, int hall);
	public List<Session> findByCinemaID(int cinemeID);
	public List<Session> findByMovieName(String movieName);
	public List<Session> findByTime(Date startTime, Date endTime);
	
	public List<Session> findByCinemaIdAndMovieName(int cinemaID,String movieName);
	public List<Session> findByCinemaIdAndTime(int cinemaID,Date startTime, Date endTime);
	
	public int insert(Session session);
	public int update(Session session);
	public int delete(int sessionID);
}
