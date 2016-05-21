package com.march.ticketjdbc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.model.*;

@Service
public class GetJsonStringService {

	@Autowired
	MovieService movieService;

	@Autowired
	CinemaService cinemaService;
	
	//wujiahui
	@Autowired
	private SessionService sessionService;
	
	//wujiahui
	@Autowired
	private SeatService seatService;
	
	public Object getCurrentMovieListJson(int num) {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get allMovies
		List<Movie> allMovies = movieService.findAll();
		allMovies = allMovies.subList(0, allMovies.size() > num ? num : allMovies.size());

		data.setList(allMovies);
		return GetJsonString("success", data);
	}

	public Object GetCinemaListJson(int movieId) {
		JsonData data = new JsonData();
		data.setError_code("0");
		List<Cinema> allCinemas = cinemaService.findCinemasByMovie(movieId);
		data.setList(allCinemas);

		return GetJsonString("success", data);
	}

	//wujiahui
	public Object GetSectionListJson(String movieName, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");
			
			// TODO the right way to get all Sessions
		List<Session> all = (List<Session>) sessionService.findSessionsByMovieAndCinema(cinemaId, movieName);
		data.setList(all);

		return GetJsonString("success", data);
	}
	
	
	//wujiahui
		public Object GetSectionInfoJson(int sessionId) {
			JsonData data = new JsonData();
			data.setError_code("0");
				
				// TODO the right way to get all Sessions
			
			
			Seat seat = seatService.getSeatBySessionId(sessionId);
			data.setList(TransSoldList(seat.getSold_list()));
			data.setH(10);
			data.setW(10);
		

			return GetJsonString("success", data);
		}

	private Object GetJsonString(String status, JsonData data) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("status", status);
		map.put("data", data);

		return map;
	}
	
	
	//‘› ±∏È÷√ wujiahui
	private List<int[]> TransSoldList(String soldList) {
		char[] seatList = soldList.toCharArray();
		
		int len = seatList.length;
		
		List<int[]> result = new ArrayList<int[]>();
		
		
		for (int i = 0; i < len; i++) {
			
			if (seatList[i] == '1') {
				int[] temp = new int[2];
				temp[0] = i/10;
				temp[1] = i%10;
				result.add(temp);
			}
			
		}
		
		return result;
	}
}
