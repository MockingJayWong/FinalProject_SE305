package com.march.ticketjdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.JsonModule;
import com.march.ticketjdbc.service.GetJsonStringService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private GetJsonStringService jsonService;
	@Autowired  
	private HttpSession httpSession;  
	
	@RequestMapping(value = "createOrder", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getJson(int sessionId, String seats) {
		return jsonService.createOrder(Integer.parseInt(httpSession.getAttribute("userId").toString()),sessionId, seats);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetOrderDetailModule.class)
	public Object getJson(int orderId) {
		return jsonService.getOrderDetail(orderId);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Object getMovie(@PathVariable("id") int id) {
		return "order.jsp";
	}
}
