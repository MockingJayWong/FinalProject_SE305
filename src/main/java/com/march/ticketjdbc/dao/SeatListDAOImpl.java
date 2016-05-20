package com.march.ticketjdbc.dao;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.march.ticketjdbc.model.*;

public class SeatListDAOImpl implements SeatListDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Seat> findAll() {
		return jdbcTemplate.query("select * from seat",
				new BeanPropertyRowMapper<Seat>(Seat.class));
	}

	// Date comparing dai ding
	@Override
	public List<Seat> findByCinemaIdAndHall(int cinemaID, int hall, Date time) {
		List<Seat> result = new ArrayList<Seat>();
		List<Session> sessions = jdbcTemplate.query("select * from session where cinemaID = ? and hall = ? and time >= start_time and time <= end_time",
				new BeanPropertyRowMapper<Session>(Session.class),
				new Object[] { cinemaID, hall, time });
		
		for (Session session : sessions) {
			result.addAll(jdbcTemplate.query("select * from seat where sessionID = ?",
					new BeanPropertyRowMapper<Seat>(Seat.class), session.getId()));
		}
		return result;
	}

	@Override
	public Seat findBySessionId(int sessionID) {
		try {
			return jdbcTemplate.queryForObject("select * from seat where sessionID = ?",
					new BeanPropertyRowMapper<Seat>(Seat.class), sessionID);
		}
		catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Seat findById(int seatID) {
		try {
			return jdbcTemplate.query("select * from seat where id = ?",
					new BeanPropertyRowMapper<Seat>(Seat.class), seatID).get(0);
		}
		catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public int insert(Seat seat) {
		return jdbcTemplate.update("insert into seat(sessionID, sold_list) values(?, ?)",
				new Object[] { seat.getSessionID(), seat.getSold_list() });
	}

	@Override
	public int update(Seat seat) {
		return jdbcTemplate.update("update ticket set sessionID = ?, sold_list = ? where id = ?",
				new Object[] { seat.getSessionID(), seat.getSold_list(), seat.getId() });
	}

	@Override
	public int delete(int seatID) {
		return jdbcTemplate.update("delete from seat where id = ?", seatID);
	}

}
