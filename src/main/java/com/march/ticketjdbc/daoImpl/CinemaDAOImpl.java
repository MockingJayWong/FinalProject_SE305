package com.march.ticketjdbc.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.march.ticketjdbc.daointerface.CinemaDAO;
import com.march.ticketjdbc.model.Cinema;

public class CinemaDAOImpl implements CinemaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Cinema> findAll() {
		return jdbcTemplate.query("select * from cinema", new BeanPropertyRowMapper<Cinema>(Cinema.class));
	}

	@Override
	public Cinema findByCinemaName(String cinemaName) {
		return jdbcTemplate.queryForObject("select * from cinema where cinemaName = ?",
				new BeanPropertyRowMapper<Cinema>(Cinema.class), cinemaName);
	}
	
	@Override
	public Cinema findByUserName(String userName) {
		return jdbcTemplate.queryForObject("select * from cinema where username = ?",
				new BeanPropertyRowMapper<Cinema>(Cinema.class), userName);
	}

	@Override
	public Cinema findById(int cinemaID) {
		return jdbcTemplate.queryForObject("select * from cinema where id = ?",
				new BeanPropertyRowMapper<Cinema>(Cinema.class), cinemaID);
	}

	@Override
	public int insert(Cinema cinema) {
		return jdbcTemplate.update("insert into cinema(cinemaName,address,password,telephone,email) values(?,?,?,?,?)",
				new Object[] {cinema.getCinemaName(),cinema.getAddress()
						,cinema.getPassword(),cinema.getTelephone(),cinema.getEmail()});
	}

	@Override
	public int update(Cinema cinema) {
		return jdbcTemplate.update("update cinema set cinemaName = ?,address=?,password=?,telephone=?, email=? where id = ?",
				new Object[] {cinema.getCinemaName(),cinema.getAddress()
						,cinema.getPassword(),cinema.getTelephone(),cinema.getEmail(), cinema.getId()});
	}

	@Override
	public int delete(int cinemaID) {
		return jdbcTemplate.update("delete from cinema where id =" + cinemaID + "");
	}

}
