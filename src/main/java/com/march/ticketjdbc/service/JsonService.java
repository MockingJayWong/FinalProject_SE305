package com.march.ticketjdbc.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class JsonService {
	@Autowired
	private Map<String,Object> JsonServicemap;
	
	@Autowired
	private Map<String,Object> JsonServicedatamap;

	
	@Autowired
	private JsonMovieListService jsonmovielistService;
	

	
	public void setStatus(String status) {
		JsonServicemap.put("status", status);
	}
	
	public void setError_code(int Errcode) {
		JsonServicedatamap.put("error_code", Errcode);
	}
	
	public Map<String,Object> getJsonMovieList() {
		jsonmovielistService.getMovieList();
		JsonServicedatamap.put("list",jsonmovielistService.getJsonMovieList());
		JsonServicemap.put("data", JsonServicedatamap);
		return JsonServicemap;
	}
}
