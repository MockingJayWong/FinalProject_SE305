package com.example.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.model.Movie;

@Component
public class MovieDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Collection<Movie> findAll() {
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	public Movie find(int id) {
		return jdbcTemplate.queryForObject("select * from movie where id = ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), id);
	}

	public int addMovie(Movie movie) {
		return jdbcTemplate.update("insert into movie(name, description, price) values(?, ?, ?)",
				new Object[] { movie.getName(), movie.getDescription(), movie.getPrice() });
	}
}
