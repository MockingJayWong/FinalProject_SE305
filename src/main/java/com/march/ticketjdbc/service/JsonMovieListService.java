package com.march.ticketjdbc.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.march.ticketjdbc.model.Movie;

public class JsonMovieListService {
	@Autowired
	private MovieService movieService;
	
	private Collection<Movie> movieList;
	
	public void getMovieList() {
		movieList = movieService.findAll();
	}
	
	public Collection<Map<String,Object>> getJsonMovieList() {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map;
		Movie mv;
		for (Iterator<Movie> iter = movieList.iterator(); iter.hasNext(); ) {
			mv = iter.next();
			map = new HashMap<String,Object>();
			map.put("movieId", mv.getId());
			map.put("name", mv.getMovieName());
			map.put("intro", mv.getIntroduction());
			map.put("url", mv.getUrl() );
			map.put("rank", mv.getScore());
			list.add(map);
		}
		return list;
	}
	
	
}
