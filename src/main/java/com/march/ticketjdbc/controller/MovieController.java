package com.march.ticketjdbc.controller;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.*;
import com.march.ticketjdbc.service.*;

@Controller
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private GetJsonStringService jsonService;

	
	@RequestMapping(value = "currentMovieList", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetMovieListModule.class)
	public Object getCurrentMovieList() {
		return jsonService.getCurrentMovieListJson(5);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Object getMovie(@PathVariable("id") int id) {
		return "movie";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetMovieDetailModule.class)
	public Object getMovieDetail(@RequestParam("movieId") int id) {
		return jsonService.getMovieDetail(id);
	}
	
//	@RequestMapping(value = "adder", method = RequestMethod.GET)
//	public Object addMovieView(ModelMap map) {
//		map.addAttribute(new Movie());
//		return "addmovie";
//	}
//	
//	@RequestMapping(value = "addMovie", method = RequestMethod.POST)
//	@ResponseBody
//	public Object addMovie(@ModelAttribute Movie movie) {
//		return jsonService.insertMovie(movie);
//	}

}
