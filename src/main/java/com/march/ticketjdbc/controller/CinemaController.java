package com.march.ticketjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.JsonModule;
import com.march.ticketjdbc.service.GetJsonStringService;

@Controller
@RequestMapping("cinema")
public class CinemaController {

	@Autowired
	private GetJsonStringService jsonService;
	
	@RequestMapping(value = "cinemaList", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetCinemaListModule.class)
	public Object getJson(@RequestParam("movieId") int id) {
		return jsonService.GetCinemaListJson(id);
	}
	
}
