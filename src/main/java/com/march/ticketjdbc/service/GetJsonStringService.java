package com.march.ticketjdbc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.model.*;

@Service
public class GetJsonStringService {

	@Autowired
	MovieService movieService;

	@Autowired
	CinemaService cinemaService;
	
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

	public Object GetSectionListJson(int movieId, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");
		
		// TODO the right way to get all Sessions
		List<Session> all = null;
		data.setList(all);

		return GetJsonString("success", data);
	}

	private Object GetJsonString(String status, JsonData data) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("status", status);
		map.put("data", data);

		return map;
	}
}
