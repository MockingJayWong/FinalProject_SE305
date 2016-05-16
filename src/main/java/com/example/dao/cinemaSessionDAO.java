package com.example.dao;

import java.sql.Date;
import java.util.Collection;

import com.example.model.Session;


public interface cinemaSessionDAO {
	public Collection<Session> findAll();

	public Session findByID(int SessionId);
	public Collection<Session> findByCinemeIdAndHall(int cinemaID, int hall);
	public Collection<Session> findByCinemaID(int cinemeID);
	public Collection<Session> findByMovieName(String movieName);
	public Collection<Session> findByTime(Date startTime, Date endTime);
	
	public Collection<Session> findByCinemaIdAndMovieName(int cinemaID,String movieName);
	public Collection<Session> findByCinemaIdAndTime(int cinemaID,Date startTime, Date endTime);
	
	public int insert(Session session);
	public int update(Session session);
	public int delete(int sessionID);
}
