package com.march.ticketjdbc.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.model.*;

public class GetJsonStringService {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ByteArrayOutputStream byteArrayOutputStream;

	@Autowired
	MovieService movieService;

	@Autowired
	CinemaService cinemaService;

	
	public String getCurrentMovieListJson() {
		JsonData data = new JsonData();
		data.setError_code("0");

		// TODO the right way to get allMovies
		List<Movie> allMovies = movieService.findAll();

		data.setList(allMovies);
		return GetJsonString("success", data, JsonData.GetListModule.class);
	}

	public String GetCinemaListJson(int movieId) {
		JsonData data = new JsonData();
		data.setError_code("0");
		List<Cinema> allCinemas = cinemaService.findCinemasByMovie(movieId);
		data.setList(allCinemas);

		return GetJsonString("success", data, JsonData.GetListModule.class);
	}

	public String GetSectionListJson(int movieId, int cinemaId) {
		JsonData data = new JsonData();
		data.setError_code("0");
		
		// TODO the right way to get all Sessions
		List<Session> all = null;
		data.setList(all);

		return GetJsonString("success", data, JsonData.GetListModule.class);
	}

	private String GetJsonString(String status, JsonData data, Class<?> module) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("status", status);
		map.put("data", data);

		try {
			objectMapper.writerWithView(module).writeValue(byteArrayOutputStream, map);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String res = byteArrayOutputStream.toString();
		byteArrayOutputStream.reset();
		return res;
	}
}
