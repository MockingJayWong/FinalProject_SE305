package com.march.ticketjdbc.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.march.ticketjdbc.daointerface.SessionDAO;
import com.march.ticketjdbc.model.Session;

public class SessionDAOImpl implements SessionDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Session> findAll() {
		return jdbcTemplate.query("select * from session", new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public Session findByID(int SessionId) {
		return jdbcTemplate.queryForObject("select * from session where id = ?",new Object[]{SessionId} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByCinemeIdAndHall(int cinemaID, int hall) {
		return jdbcTemplate.query("select * from session where cinemaID = ? and hall = ?",
				new Object[]{cinemaID, hall} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByCinemaID(int cinemeID) {
		return jdbcTemplate.query("select * from session where cinemaID = ?",new Object[]{cinemeID} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByMovieName(String movieName) {
		return jdbcTemplate.query("select * from session where movieName = ?",new Object[]{movieName} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByTime(Long startTime, Long endTime) {
		return jdbcTemplate.query("select * from session where start_time >= ? and end_time <= ?",new Object[]{startTime, endTime} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByCinemaIdAndMovieName(int cinemaID, String movieName) {
		return jdbcTemplate.query("select * from session where movieName = ? and cinemaID = ?",
				new Object[]{movieName, cinemaID} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public List<Session> findByCinemaIdAndTime(int cinemaID, Long startTime, Long endTime) {
		return jdbcTemplate.query("select * from session where cinemaID = ? and start_time >= ? and end_time <= ?",new Object[]{cinemaID,startTime, endTime} ,new BeanPropertyRowMapper<Session>(Session.class));
	}

	@Override
	public int insert(final Session session) {

		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into session(cinemaID,hall,movieName,start_time,end_time,language, price) values(?,?,?,?,?,?,?)", new String[]{"id"});
				st.setInt(1,session.getCinemaID());
				st.setInt(2, session.getHall());
				st.setString(3, session.getMovieName());
				st.setLong(4, session.getStart_time());
				st.setLong(5, session.getEnd_time());
				st.setString(6, session.getLanguage());
				st.setFloat(7, session.getPrice());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
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
