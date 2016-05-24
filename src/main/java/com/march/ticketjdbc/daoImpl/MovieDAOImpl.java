package com.march.ticketjdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return jdbcTemplate.queryForObject("select * from movie where id = ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), id);
	}
	
	//public List<Movie> findByTime(Date StartTime)
	
	public Movie findByMovieName(String name) {
		return jdbcTemplate.queryForObject("select * from movie where movieName = ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), name);
	}

	public int insert(final Movie movie) {
		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into movie(movieName, url, introduction, score) values(?, ?, ?, ?)", new String[]{"id"});
				st.setString(1, movie.getMovieName());
				st.setString(2, movie.getUrl());
				st.setString(3, movie.getIntroduction());
				st.setFloat(4, movie.getScore());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}
	
	public int update(Movie movie) {
		return jdbcTemplate.update("update movie set movieName = ?,url = ?,introduction = ?,score = ? where id = ?",
				new Object[] {movie.getMovieName(),movie.getUrl(), movie.getIntroduction(), movie.getScore(),movie.getId()});
	}
	
	public int delete(int movieID) {
		return jdbcTemplate.update("delete from movie where id = " + movieID + "");
	}
}
