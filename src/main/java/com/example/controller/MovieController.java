package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Movie;
import com.example.service.*;

@Controller
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute(new Movie());
		modelMap.put("movies", movieService.findAll());
		return "movie/index";
	}
	
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("movie", movieService.find(id));
		return "movie/detail";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addMovie(Movie movie, final BindingResult bindingResult, final ModelMap model) {
		if (bindingResult.hasErrors()) {
            return "movie/index";
        }
        movieService.addMovie(movie);
        model.clear();
        return "redirect:/movie";
	}
}
