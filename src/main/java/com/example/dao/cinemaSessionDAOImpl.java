package com.example.dao;

import java.sql.Date;
import java.util.Collection;

import com.example.model.Session;

public class cinemaSessionDAOImpl implements cinemaSessionDAO{

	@Override
	public Collection<Session> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session findByID(int SessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session findByCinemeIdAndHall(int cinemaID, int hall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Session> findByCinemaID(int cinemeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Session> findByMovieName(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Session> findByTime(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Session> findByCinemaIdAndMovieName(int cinemaID, String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Session> findByCinemaIdAndTime(int cinemaID, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int sessionID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
