package com.march.ticketjdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
		try {
			return jdbcTemplate.queryForObject("select * from cinema where cinemaName = ?",
					new BeanPropertyRowMapper<Cinema>(Cinema.class), cinemaName);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public Cinema findByUserName(String userName) {
		try {
			return jdbcTemplate.queryForObject("select * from cinema where username = ?",
					new BeanPropertyRowMapper<Cinema>(Cinema.class), userName);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Cinema findById(int cinemaID) {
		try {
			return jdbcTemplate.queryForObject("select * from cinema where id = ?",
					new BeanPropertyRowMapper<Cinema>(Cinema.class), cinemaID);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int insert(final Cinema cinema) {
		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into cinema(cinemaName,address,username,password,telephone,email) values(?,?,?,?,?,?)", new String[]{"id"});
				st.setString(1, cinema.getCinemaName());
				st.setString(2, cinema.getAddress());
				st.setString(3, cinema.getUsername());
				st.setString(4, cinema.getPassword());
				st.setString(5, cinema.getTelephone());
				st.setString(6, cinema.getEmail());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();	
	}

	@Override
	public int update(Cinema cinema) {
		return jdbcTemplate.update("update cinema set cinemaName = ?,address=?,username=?,password=?,telephone=?, email=? where id = ?",
				new Object[] {cinema.getCinemaName(),cinema.getAddress(),cinema.getUsername()
						,cinema.getPassword(),cinema.getTelephone(),cinema.getEmail(), cinema.getId()});
	}

	@Override
	public int delete(int cinemaID) {
		return jdbcTemplate.update("delete from cinema where id =" + cinemaID + "");
	}

}
