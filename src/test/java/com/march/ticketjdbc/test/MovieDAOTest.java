package com.march.ticketjdbc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.march.ticketjdbc.daoImpl.MovieDAOImpl;
import com.march.ticketjdbc.model.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class MovieDAOTest {

	@Autowired
	private MovieDAOImpl movieDAO;
	
	@Test
	public void addMovie() {
		Movie movie = new Movie("JUNIT", "a.org", "my god!", 12.9f, 123l, 345l);
		movieDAO.insert(movie);
	}
	
	@Test
	public void getallMovies() {
		List<Movie> m = movieDAO.findAll();
		System.out.println(m);
	}
}
