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
import org.springframework.stereotype.Component;

import com.march.ticketjdbc.daointerface.MovieDAO;
import com.march.ticketjdbc.model.Movie;

@Component
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Movie> findAll() {
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	public Movie findByID(int id) {
		try {
			return jdbcTemplate.queryForObject("select * from movie where id = ?",
					new BeanPropertyRowMapper<Movie>(Movie.class), id);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Movie> findByTime(long start_time, long end_time) {
		return jdbcTemplate.query("select * from movie where start_time >= ? and end_time <= ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), new Object[] {start_time, end_time});
	}
	
	public Movie findByMovieName(String name) {
		try {
			return jdbcTemplate.queryForObject("select * from movie where movieName = ?",
					new BeanPropertyRowMapper<Movie>(Movie.class), name);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int insert(final Movie movie) {
		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into movie(movieName, url, type, introduction, score, start_time, end_time, length, director, actor) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
				st.setString(1, movie.getMovieName());
				st.setString(2, movie.getUrl());
				st.setString(3, movie.getType());
				st.setString(4, movie.getIntroduction());
				st.setFloat(5, movie.getScore());
				st.setLong(6, movie.getStart_time());
				st.setLong(7, movie.getEnd_time());
				st.setLong(8, movie.getLength());
				st.setString(9, movie.getDirector());
				st.setString(10, movie.getActor());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}
	
	public int update(Movie movie) {
		return jdbcTemplate.update("update movie set movieName = ?, url = ?, type = ?, introduction = ?, score = ?, start_time = ?, end_time = ?, length = ?, director = ?, actor = ? where id = ?",
				new Object[] {movie.getMovieName(), movie.getUrl(), movie.getType(), movie.getIntroduction(), movie.getScore(), movie.getStart_time(), movie.getEnd_time(), movie.getLength(),  movie.getDirector(), movie.getActor(), movie.getId()});
	}
	
	public int delete(int movieID) {
		return jdbcTemplate.update("delete from movie where id = " + movieID + "");
	}
}
