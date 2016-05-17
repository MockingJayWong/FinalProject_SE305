package com.example.dao;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.Session;

public class cinemaSessionDAOImpl implements cinemaSessionDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Session> findAll() {
		return jdbcTemplate.query("select * from session", new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Session findByID(int SessionId) {
		return jdbcTemplate.queryForObject("select * from session where id = ?",new Object[]{SessionId} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByCinemeIdAndHall(int cinemaID, int hall) {
		return jdbcTemplate.query("select * from session where cinemaID = ? and hall = ?",
				new Object[]{cinemaID, hall} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByCinemaID(int cinemeID) {
		return jdbcTemplate.query("select * from session where cinemaID = ?",new Object[]{cinemeID} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByMovieName(String movieName) {
		return jdbcTemplate.query("select * from session where movieName = ?",new Object[]{movieName} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByTime(Date startTime, Date endTime) {
		return jdbcTemplate.query("select * from session where start_time > ? and end_time < ?",new Object[]{startTime, endTime} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByCinemaIdAndMovieName(int cinemaID, String movieName) {
		return jdbcTemplate.query("select * from session where movieName = ? and cinemaID",
				new Object[]{movieName, cinemaID} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Collection<Session> findByCinemaIdAndTime(int cinemaID, Date startTime, Date endTime) {
		return jdbcTemplate.query("select * from session where cinemaID = ? and start_time > ? and end_time < ?",new Object[]{cinemaID,startTime, endTime} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public int insert(Session session) {
		return jdbcTemplate.update("insert into session(cinemaID,hall,movieName,start_time,end_time,language, price) values(?,?,?,?,?,?,?)",
				new Object[] {session.getCinemaID(),session.getHall(),
						session.getMovieName(),session.getStart_time(),session.getEnd_time(),
						session.getLanguage(),session.getPrice()});
	}

	@Override
	public int update(Session session) {
		return jdbcTemplate.update(
				"update session set cinemaID = ?,hall = ?,movieName=?,start_time=?,end_time=?,language=?,price=? where id = ?",
				new Object[] {session.getCinemaID(),session.getHall(),
						session.getMovieName(),session.getStart_time(),session.getEnd_time(),
						session.getLanguage(),session.getPrice(), session.getId()});
	}

	@Override
	public int delete(int sessionID) {
		return jdbcTemplate.update("delete from session where id =" + sessionID + "");
	}

}
