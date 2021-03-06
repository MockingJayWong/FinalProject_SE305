package com.march.ticketjdbc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;
import com.march.ticketjdbc.model.JsonData;
import com.march.ticketjdbc.model.JsonModule;
import com.march.ticketjdbc.model.User;
import com.march.ticketjdbc.service.GetJsonStringService;

@Controller
@RequestMapping("account")
public class UserController {
	@Autowired
	private GetJsonStringService jsonService;
	
	private int maxAge = 7 * 24 * 60 * 60;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public Object getRegisterPage() {
		return "register";
	}
		
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getRegisterJson(HttpServletRequest request,HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Map<String, Object> map = (Map<String, Object> ) jsonService.userRegister(username, password, password2, telephone, email);
		
		return map;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Object getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	@JsonView(JsonModule.UserLoginModule.class)
	public Object getLoginJson(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url  = request.getParameter("currentUrl");
		
		@SuppressWarnings("unchecked")
		Map<String, Object>map = (Map<String, Object>) jsonService.userLogin(username, password, url);
		if ( ((String) map.get("status")).equals("success")  ) {
			JsonData data = (JsonData)map.get("data");
			String userId = Integer.toString(data.getUser().getId());
			Cookie userIdCookie = new Cookie("userId", userId);
			Cookie passwordCookie = new Cookie("password", password);
			Cookie usernameCookie = new Cookie("username", username);
			
			userIdCookie.setPath("/");
			passwordCookie.setPath("/");
			usernameCookie.setPath("/");
			
			userIdCookie.setMaxAge(maxAge);
			passwordCookie.setMaxAge(maxAge);
			usernameCookie.setMaxAge(maxAge);
			
			response.addCookie(userIdCookie);
			response.addCookie(passwordCookie);
			response.addCookie(usernameCookie);
			
			session.setAttribute("userId", userId);
			
		}

		return map;
	}
	
	@RequestMapping(value="logOut")
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		Cookie userIdCookie = new Cookie("userId",null);
		Cookie passwordCookie = new Cookie("password",null);
		Cookie usernameCookie = new Cookie("username", null);
		
		userIdCookie.setPath("/");  
		passwordCookie.setPath("/");
		usernameCookie.setPath("/");
		
        response.addCookie(userIdCookie); 
        response.addCookie(passwordCookie);
		response.addCookie(usernameCookie);
        
        try {
			response.sendRedirect("/ticketjdbc/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public Object getUserPage(HttpServletRequest request) {
		return "user";
	}
	
	@RequestMapping(value = "user/info", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getInfoJson(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String) session.getAttribute("userId"));
			return jsonService.getUserInfo(userId);
	}
	
	@RequestMapping(value = "change", method = RequestMethod.POST)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getChangeJson(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String) session.getAttribute("userId"));
		String password = request.getParameter("password");
		return jsonService.userChange(userId, password);
	}
	
	@RequestMapping(value = "user/orderList", method = RequestMethod.GET)
	public Object orderList() {
		return "orderList";
	}
}
