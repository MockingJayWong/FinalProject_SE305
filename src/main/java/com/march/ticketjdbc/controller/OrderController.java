package com.march.ticketjdbc.controller;

import javax.servlet.http.*;

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
@RequestMapping("order")
public class OrderController {
	@Autowired
	private GetJsonStringService jsonService;
	
	@RequestMapping(value = "createOrder", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.CreateOrderModule.class)
	public Object getJson(HttpServletRequest request) {
		int userId = Integer.parseInt((String) request.getSession().getAttribute("userId"));
		int sessionId = Integer.parseInt(request.getParameter("sessionId"));
		String seats = request.getParameter("seats");
		return jsonService.createOrder(userId,sessionId, seats);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetOrderDetailModule.class)
	public Object getJson(int orderId) {
		return jsonService.getOrderDetail(orderId);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Object getMovie(@PathVariable("id") int id) {
		return "order";
	}
	
	@RequestMapping(value = "payOrder", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.GetOrderDetailModule.class)
	public Object PayOrder(int orderID) {
		return jsonService.EasyPayOrder(orderID);
	}
}
