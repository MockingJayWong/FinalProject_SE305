package com.march.ticketjdbc.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.model.JsonModel;
import com.march.ticketjdbc.model.Movie;

public class JsonMovieListService {
	@Autowired
	private MovieService movieService;

	@Autowired
	private JsonData jsondata;
	
	@Autowired
	private JsonModel jsonmodel;
	
	public JsonModel getJsonMovieList() {
		jsondata.setList(movieService.findAll());
		jsondata.setObject(null);
		jsondata.setError_code(0);
		jsonmodel.setData(jsondata);
		jsonmodel.setStatus("OK");
		return jsonmodel;
	}
	
	
}
