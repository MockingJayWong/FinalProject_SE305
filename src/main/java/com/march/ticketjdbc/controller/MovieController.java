package com.march.ticketjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String index(ModelMap modelMap) {
//		modelMap.addAttribute(new Movie());
//		modelMap.put("movies", movieService.findAll());
//		return "movie/index";
//	}
//	
//	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
//	public String detail(@PathVariable("id") int id, ModelMap modelMap) {
//		modelMap.put("movie", movieService.find(id));
//		return "movie/detail";
//	}
//	
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//	public String qString(@RequestParam("movieID") int id, ModelMap modelMap) {
//		modelMap.put("movie", movieService.find(id));
//		return "movie/detail";
//	}
//	
//	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
//	public String delete(@PathVariable("id") int id, ModelMap modelMap) {
//		movieService.deleteMovie(id);
//		modelMap.clear();
//		return "redirect:/movie";
//	}
	
	@RequestMapping(value = "currentMovieList", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetMovieListModule.class)
	public Object getJson() {
		return jsonService.getCurrentMovieListJson(5);
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String addMovie(@ModelAttribute("movie") Movie movie, final BindingResult bindingResult, final ModelMap model) {
//		if (bindingResult.hasErrors()) {
//            return "movie/index";
//        }
//        movieService.addMovie(movie);
//        model.clear();
//        return "redirect:/movie";
//	}
}
