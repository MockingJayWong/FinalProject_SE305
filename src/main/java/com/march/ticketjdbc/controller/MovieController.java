package com.march.ticketjdbc.controller;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.*;
import com.march.ticketjdbc.service.*;

@Controller
@RequestMapping("movie")
public class MovieController {

//	@Autowired
//	private MovieService movieService;
	
	@Autowired
	private GetJsonStringService jsonService;
	
	@Autowired
	private MovieService movieService;

	
	@RequestMapping(value = "currentMovieList", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetMovieListModule.class)
	public Object getJson() {
		Movie movie = movieService.find(324234);
		return jsonService.getCurrentMovieListJson(5);
	}
	
	@RequestMapping(value = "adder", method = RequestMethod.GET)
	public Object addMovieView(ModelMap map) {
		map.addAttribute(new Movie());
		return "addmovie";
	}
	
	@RequestMapping(value = "addMovie", method = RequestMethod.POST)
	@ResponseBody
	public Object addMovie(@ModelAttribute Movie movie) {
		return jsonService.insertMovie(movie);
	}



	

	
	
}
