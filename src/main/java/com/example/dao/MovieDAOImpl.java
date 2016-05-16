package com.example.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.model.Movie;

@Component
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Collection<Movie> findAll() {
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	public Movie findByID(int id) {
		return jdbcTemplate.queryForObject("select * from movie where id = ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), id);
	}
	
	//public Collection<Movie> findByTime(Date StartTime)
	
	public Movie findByMovieName(String name) {
		return jdbcTemplate.queryForObject("select * from movie where movieName = ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), name);
	}

	public int insert(Movie movie) {
		return jdbcTemplate.update("insert into movie(name, description, price) values(?, ?, ?)",
				new Object[] { movie.getMovieName(), movie.getIntroduction(), movie.getScore() });
	}
	
	public int update(Movie movie) {
		return jdbcTemplate.update("update movie set movieName = ?,url = ?,introduction = ?,score = ? where id = ?",
				new Object[] {movie.getMovieName(),movie.getUrl(), movie.getIntroduction(), movie.getScore(),movie.getId()});
	}
	
	public int delete(int movieID) {
		return jdbcTemplate.update("delete from movie where id = " + movieID + "");
	}
}
