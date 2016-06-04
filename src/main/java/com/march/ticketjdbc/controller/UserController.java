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
import com.march.ticketjdbc.model.JsonModule;
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

		if (((String)map.get("status")).equals("success")) {
			try {
				response.sendRedirect("/ticketjdbc/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Object getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getLoginJson(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Map<String, Object>map = (Map<String, Object>) jsonService.userLogin(username, password);
		if ( ((String) map.get("status")).equals("success")  ) {
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			
			usernameCookie.setPath("/");
			passwordCookie.setPath("/");
			
			usernameCookie.setMaxAge(maxAge);
			passwordCookie.setMaxAge(maxAge);
			
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			
			session.setAttribute("username", username);
		}
		
		return map;
	}
	
	@RequestMapping(value="logOut")
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		Cookie usernameCookie = new Cookie("username",null);
		Cookie passwordCookie = new Cookie("password",null);
		
		usernameCookie.setPath("/");  
		passwordCookie.setPath("/");
		
        response.addCookie(usernameCookie); 
        response.addCookie(passwordCookie);
		try {
			response.sendRedirect("/ticketjdbc/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public Object getUserPage(@PathVariable("id") int id) {
		return "user";
	}
	
	@RequestMapping(value = "user/info", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getInfoJson(int userId) {
		return jsonService.userInfo(userId);
	}
	
	@RequestMapping(value = "change", method = RequestMethod.GET)
	@ResponseBody
	@JsonView(JsonModule.UserModule.class)
	public Object getChangeJson(String username, String password, String telephone, String email) {
		return jsonService.userChange(username, password, telephone, email);
	}
	
	
}
