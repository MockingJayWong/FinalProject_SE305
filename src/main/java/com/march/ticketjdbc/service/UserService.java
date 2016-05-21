package com.march.ticketjdbc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.march.ticketjdbc.dao.UserDAOImpl;
import com.march.ticketjdbc.model.User;

public class UserService {
	@Autowired
	UserDAOImpl userDAO;
	
	public String login(String username, String password) {
		User user = userDAO.findByName(username);
		if (user == null || !user.getPassword().equals(password))
			return "username or password error";
		return "success";
	}
	
	public String sign(String username, String password, String telephone, String email) {
		User user = userDAO.findByName(username);
		if (user == null) {
			userDAO.insert(new User(username, password, telephone, email));
			return "this username already exists";
		}
		return "success";
	}
	
	public String change(String username, String password, String telephone, String email) {
		if (password == null || password.length() == 0)
			return "password can not be empty";
		User user = userDAO.findByName(username);
		user.setPassword(password);
		
		if (telephone == null || telephone.length() == 0) user.setTelephone("");
		else user.setTelephone(telephone);
		
		if (email == null || email.length() == 0) user.setEmail("");
		else user.setEmail(email);
		
		userDAO.update(user);
		return "success";
	}
	
	public User getInfo(String username) {
		return userDAO.findByName(username);
	}
}
