package com.march.ticketjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.JsonModule;
import com.march.ticketjdbc.service.GetJsonStringService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private GetJsonStringService jsonService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getLoginJson(String username, String password) {
		return jsonService.userLogin(username, password);
	}
	
	@RequestMapping(value = "sign", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getSignJson(String username, String password, String telephone, String email) {
		return jsonService.userSign(username, password, telephone, email);
	}
	
	@RequestMapping(value = "change", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getChangeJson(String username, String password, String telephone, String email) {
		return jsonService.userChange(username, password, telephone, email);
	}
	
	@RequestMapping(value = "getInfo", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getInfoJson(String username) {
		return jsonService.userInfo(username);
	}
}
