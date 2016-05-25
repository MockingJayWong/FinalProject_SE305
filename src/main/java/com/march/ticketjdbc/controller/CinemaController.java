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
	public Object getCinemaListJson(@RequestParam(value = "movieId", required = false) Integer id) {
		return jsonService.GetCinemaListJson(id);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getLoginJson(String username, String password) {
		return jsonService.cinemaLogin(username, password);
	}
	
	@RequestMapping(value = "sign", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getSignJson(String cinemaName, String address, String username, String password, String telephone, String email) {
		return jsonService.cinemaSign(cinemaName, address, username, password, telephone, email);
	}
	
	@RequestMapping(value = "change", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getChangeJson(String cinemaName, String address, String username, String password, String telephone, String email) {
		return jsonService.cinemaChange(cinemaName, address, username, password, telephone, email);
	}
	
	@RequestMapping(value = "getInfo", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getInfoJson(String username) {
		return jsonService.cinemaInfo(username);
	}
}
