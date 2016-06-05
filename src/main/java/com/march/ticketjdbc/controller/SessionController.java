package com.march.ticketjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.JsonModule;
import com.march.ticketjdbc.service.GetJsonStringService;

@Controller
@RequestMapping("session")
public class SessionController {
	
	@Autowired
	private GetJsonStringService jsonService;
	
	@ResponseBody
	@RequestMapping("/sessionList")
	@JsonView(JsonModule.GetSessionListModule.class)
	public Object index(@RequestParam(value="cinemaId", defaultValue="1")int cinemaId,
			@RequestParam(value="movieName", defaultValue="hello")String movieName) {
		
		return jsonService.GetSectionListJson(movieName, cinemaId);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@JsonView(JsonModule.GetSessionInfoModule.class)
	public Object  detail(@PathVariable("id") int id) {
		return jsonService.GetSectionInfoJson(id);
	}
	
	
}
