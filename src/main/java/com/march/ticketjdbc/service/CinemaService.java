package com.march.ticketjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.*;
import com.march.ticketjdbc.model.*;

@Service
public class CinemaService {

	@Autowired
	MovieDAOImpl movieDAO;
	
	@Autowired
	CinemaDAOImpl cinemaDAO;
	
	@Autowired
	SessionDAOImpl sessionDao;

	public List<Cinema> findAll() {
		return cinemaDAO.findAll();
	}
	
	public List<Cinema> findCinemasByMovie(int movieId) {
		List<Cinema> cinemas = new ArrayList<Cinema>();
		String name = movieDAO.findByID(movieId).getMovieName();
		for (Session session:sessionDao.findByMovieName(name)) {
			cinemas.add(cinemaDAO.findById(session.getCinemaID()));
		}

		return cinemas;
	}
	
	public String login(String username, String password) {
		Cinema cinema = cinemaDAO.findByUserName(username);
		if (cinema == null || !cinema.getPassword().equals(password))
			return "username or password error";
		return "success";
	}
	
	public String sign(String cinemaName, String address, String username, String password, String telephone, String email) {
		Cinema cinema = cinemaDAO.findByUserName(username);
		if (cinema == null) {
			cinemaDAO.insert(new Cinema(cinemaName, address, username, password, telephone, email));
			return "this username already exists";
		}
		return "success";
	}
	
	public String change(String cinemaName, String address, String username, String password, String telephone, String email) {
		if (password == null || password.length() == 0)
			return "password can not be empty";
		Cinema cinema = cinemaDAO.findByUserName(username);
		cinema.setPassword(password);
		
		if (cinemaName == null || cinemaName.length() == 0) return "cinemaName can not be empty";
		else cinema.setCinemaName(cinemaName);
		
		if (address == null || address.length() == 0) return "address can not be empty";
		else cinema.setAddress(address);
		
		if (telephone == null || telephone.length() == 0) cinema.setTelephone("");
		else cinema.setTelephone(telephone);
		
		if (email == null || email.length() == 0) cinema.setEmail("");
		else cinema.setEmail(email);
		
		cinemaDAO.update(cinema);
		return "success";
	}
	
	public Cinema getInfo(String username) {
		return cinemaDAO.findByUserName(username);
	}
}
