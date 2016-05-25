package com.march.ticketjdbc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.daoImpl.SessionDAOImpl;
import com.march.ticketjdbc.model.*;

@Service
public class GetJsonStringService {

	@Autowired
	MovieService movieService;

	@Autowired
	CinemaService cinemaService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	// wujiahui
	@Autowired
	private SessionService sessionService;

	// wujiahui
	@Autowired
	private SeatService seatService;

	@Autowired
	SessionDAOImpl sessionDAO;

	
	// --------------------------------- Movie Json -----------------------------------
	public Object getCurrentMovieListJson(int num) {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get allMovies
		List<Movie> allMovies = movieService.findAll();
		allMovies = allMovies.subList(0, allMovies.size() > num ? num : allMovies.size());

		data.setList(allMovies);
		return GetJsonString("success", data);
	}

	public Object insertMovie(Movie movie) {
		JsonData data = new JsonData();
		data.setMovie(movieService.addMovie(movie));
		data.setError_code("0");
		return GetJsonString("success", data);
	}
	// ----------------------------- End Movie Json ----------------------------------

	
	// --------------------------------- Cinema Json -----------------------------------
	public Object GetCinemaListJson(Integer movieId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		if (movieId == null) {
			data.setList(cinemaService.findAll());
		} else {
			List<Cinema> allCinemas = cinemaService.findCinemasByMovie(movieId);
			for (Cinema cinema : allCinemas) {
				// TODO: Add sessions to each cinema
				int cinemaId = cinema.getId();
				String movieName = movieService.find(movieId).getMovieName();
				cinema.setSessions(sessionService.findSessionsByMovieAndCinema(cinemaId, movieName));
			}
			data.setList(allCinemas);
		}

		return GetJsonString("success", data);
	}
	
	public Object cinemaLogin(String username, String password) {
		return GetJsonString(cinemaService.login(username, password), null);
	}

	public Object cinemaSign(String cinemaName, String address, String username, String password, String telephone,
			String email) {
		return GetJsonString(cinemaService.sign(cinemaName, address, username, password, telephone, email), null);
	}

	public Object cinemaChange(String cinemaName, String address, String username, String password, String telephone,
			String email) {
		return GetJsonString(cinemaService.change(cinemaName, address, username, password, telephone, email), null);
	}

	public Object cinemaInfo(String username) {
		JsonData data = new JsonData();
		data.setCinema(cinemaService.getInfo(username));
		return GetJsonString("success", data);
	}
	// ------------------------------- End Cinema Json ---------------------------------
	
	
	// --------------------------------- Session Json -----------------------------------
	public Object GetSectionListJson(int movieId, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get all Sessions
		String movieName = movieService.find(movieId).getMovieName();
		List<Session> all = sessionService.findSessionsByMovieAndCinema(cinemaId, movieName);
		data.setList(all);

		return GetJsonString("success", data);
	}

	// wujiahui
	public Object GetSectionListJson(String movieName, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get all Sessions
		List<Session> all = sessionService.findSessionsByMovieAndCinema(cinemaId, movieName);
		data.setList(all);

		return GetJsonString("success", data);
	}

	// wujiahui
	public Object GetSectionInfoJson(int sessionId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get all Sessions

		Seat seat = seatService.getSeatBySessionId(sessionId);
		data.setList(TransSoldList(seat.getSold_list()));
		//data.setH(10);
		//data.setW(10);

		return GetJsonString("success", data);
	}
	// ------------------------------- End Session Json ---------------------------------
	
	
	// --------------------------------- Order Json -----------------------------------
	public Object createOrder(int userId, int cinemaId, int sessionId, String seats) {
		JsonData data = new JsonData();
		if (orderService.checkSeats(sessionId, seats)) {
			Orders order = orderService.createOrder(userId, cinemaId, sessionId, seats);
			Session session = sessionDAO.findByID(sessionId);
			List<int[]> list = TransSoldList(seats);

			data.setError_code("0");
			data.setOrder(order);
			data.setSession(session);
			data.setList(list);

			return GetJsonString("success", data);
		}
		return GetJsonString("faild", null);
	}
	// ------------------------------- End Order Json ---------------------------------
	
	
	// --------------------------------- User Json -----------------------------------
	public Object userLogin(String username, String password) {
		return GetJsonString(userService.login(username, password), null);
	}

	public Object userSign(String username, String password, String telephone, String email) {
		return GetJsonString(userService.sign(username, password, telephone, email), null);
	}

	public Object userChange(String username, String password, String telephone, String email) {
		return GetJsonString(userService.change(username, password, telephone, email), null);
	}

	public Object userInfo(String username) {
		JsonData data = new JsonData();
		data.setUser(userService.getInfo(username));
		return GetJsonString("success", data);
	}
	// ------------------------------- End User Json ---------------------------------


	private List<int[]> TransSoldList(String soldList) {
		String[] seatList = soldList.split(",");
		List<int[]> result = new ArrayList<int[]>();

		for (int i = 0; i < seatList.length; i++) {
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(seatList[i]) / 10;
			temp[1] = Integer.parseInt(seatList[i]) % 10;
			result.add(temp);
		}
		return result;
	}
	
	private Object GetJsonString(String status, JsonData data) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("status", status);
		map.put("data", data);

		return map;
	}
}
