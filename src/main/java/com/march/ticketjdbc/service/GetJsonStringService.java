package com.march.ticketjdbc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.model.*;

@Service
public class GetJsonStringService {

	@Autowired
	private MovieService movieService;

	@Autowired
	private CinemaService cinemaService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private SessionService sessionService;

	@Autowired
	private SeatService seatService;
	
	@Autowired
	private TicketService ticketService;

	
	// --------------------------------- Movie Json -----------------------------------
	public Object getCurrentMovieListJson(int num) {
		JsonData data = new JsonData();
		data.setError_code("0");

		List<Movie> allMovies = movieService.findAll();
		allMovies = allMovies.subList(0, allMovies.size() > num ? num : allMovies.size());

		data.setList(allMovies);
		return GetJsonString("success", data);
	}
	
	public Object getMovieDetail(int movieId) {
		JsonData data = new JsonData();
		data.setError_code("0");
		Movie movie = movieService.find(movieId);
		data.setMovie(movie);
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
		data.setCinema(cinemaService.getInfoByUserName(username));
		return GetJsonString("success", data);
	}
	// ------------------------------- End Cinema Json ---------------------------------
	
	
	// --------------------------------- Session Json -----------------------------------
	public Object GetSectionListJson(int movieId, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		String movieName = movieService.find(movieId).getMovieName();
		List<Session> all = sessionService.findSessionsByMovieAndCinema(cinemaId, movieName);
		data.setList(all);

		return GetJsonString("success", data);
	}

	public Object GetSectionListJson(String movieName, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		List<Session> all = sessionService.findSessionsByMovieAndCinema(cinemaId, movieName);
		data.setList(all);

		return GetJsonString("success", data);
	}

	public Object GetSectionInfoJson(int sessionId) {
		JsonData data = new JsonData();
		data.setError_code("0");

		orderService.checkOrder();
		data.setList(TransSoldList(ticketService.findBySessionID(sessionId)));
		//data.setH(10);
		//data.setW(10);

		return GetJsonString("success", data);
	}
	// ------------------------------- End Session Json ---------------------------------
	
	
	// --------------------------------- Order Json -----------------------------------
	public Object createOrder(int userId, int sessionId, String seats) {
		JsonData data = new JsonData();
		orderService.checkOrder();
		synchronized(orderService) {
			if (orderService.checkSeats(sessionId, seats)) {
				Session session = sessionService.getSessionDetailed(sessionId);
				Orders order = orderService.createOrder(userId, session.getCinemaID(), sessionId, seats);
				data.setError_code("0");
				data.setOrder(order);
	
				return GetJsonString("success", data);
			}
			return GetJsonString("create fail", null);
		}
	}
	
	public Object getOrderDetail(int orderId) {
		JsonData data = new JsonData();
		Orders order = orderService.getOrderDetail(orderId);
		if (order != null) {
			if (order.getState().equals("0")) {
				order.setState("paid");
			} else if (order.getState().equals("1")) {
				order.setState("not paid");
			} else if (order.getState().equals("2")) {
				order.setState("invalid");
			}
			
			Session session = orderService.getSessionByOrderId(order.getId());
			Cinema cinema = cinemaService.getInfoByCinemaId(order.getCinemaID());
			//seat

			List<int[]> seatList = TransSoldList(ticketService.findByOrderID(orderId));
			
			data.setError_code("0");
			data.setOrder(order);;
			data.setSession(session);
			data.setCinema(cinema);
			data.setList(seatList);
			
			return GetJsonString("success", data);
		}
		return GetJsonString("fail", null);
	}
	
	public Object EasyPayOrder(int orderID) {
		JsonData data = new JsonData();
		try {
			Orders order = orderService.getOrderDetail(orderID);
			
			if (orderService.UpdateOrderState(orderID, "0") > 0) {
				order.setState("0");
			}
			data.setOrder(order);
			return GetJsonString("success", data);
		} catch (Exception e) {
			return GetJsonString("fail", data);
		}
	}
	// ------------------------------- End Order Json ---------------------------------
	
	
	// --------------------------------- User Json -----------------------------------
	public Object userLogin(String username, String password, String url) {
		JsonData data = new JsonData();
		data.setUrl(url);
		
		User user = userService.login(username, password);
		data.setUser(user);
		return GetJsonString(user == null ? "fail" : "success", data);
	}

	public Object userLoginById(String userId, String password) {
		return GetJsonString(userService.loginById(userId, password), null);
	}
	
	public Object userRegister(String username, String password, String password2, String telephone, String email) {
		User user = userService.register(username, password, password2, telephone, email);
		if (user.getId() == -1) {
			JsonData data = new JsonData();
			data.setUser(user);
			
			return GetJsonString("fail", data);
		}
		
		return GetJsonString("success", null);
	}

	public Object userChange(String username, String password, String telephone, String email) {
		return GetJsonString(userService.change(username, password, telephone, email), null);
	}

	public Object getUserInfo(int userId) {
		JsonData data = new JsonData();
		data.setUser(userService.getInfo(userId));
		return GetJsonString("success", data);
	}
	// ------------------------------- End User Json ---------------------------------


	private List<int[]> TransSoldList(List<Ticket> ticketList) {
		
		List<int[]> result = new ArrayList<int[]>();
		
		int length = ticketList.size();
		for (int i = 0; i < length; i++) {
			int[] temp = new int[2];
			// 位置有11行11列，位置从0-120
			temp[0] = ticketList.get(i).getSeat() / 11 + 1;
			temp[1] = ticketList.get(i).getSeat() % 11 + 1;
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
