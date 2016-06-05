package com.march.ticketjdbc.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.UserDAOImpl;
import com.march.ticketjdbc.model.User;

@Service
public class UserService {
	@Autowired
	UserDAOImpl userDAO;
	
	private String usernameRegex= "^[a-zA-Z_][a-zA-Z0-9_-]{5,15}$";
	private String passwordRegex="^[a-zA-Z0-9_-]{6,16}$";
	private String emailRegex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	private String telephoneRegex="^1[0-9]{10}$";
	
	public User login(String username, String password) {
		User user = userDAO.findByName(username);
		if (user == null || !user.getPassword().equals(password))
			return null;
		return user;
	}
	
	public String loginById(String userId, String password) {
		User user = userDAO.findByID(Integer.parseInt(userId));
		if (user == null || !user.getPassword().equals(password))
			return "fail";
		return "success";
	}
	
	public User register(String username, String password, String password2, String telephone, String email) {
		boolean flag = true;
		
		//check username format and only
		Pattern pattern = Pattern.compile(usernameRegex);
		Matcher m = pattern.matcher(username);
		
		if (!m.find()) {
			flag = false;
			username = "wrong username format";
		} else {
			User user = userDAO.findByName(username);
			if (user != null) {
				flag = false;
				username = "this username already exists";
			}
		}
		
		//check password format
		pattern = Pattern.compile(passwordRegex);
		m = pattern.matcher(password);
		
		if (!m.find()) {
			flag = false;
			password = "wrong password format";
		} else {
			if (!password.equals(password2)) {
				flag = false;
				password = "password don't equals password2";
			}
		}
		
		//check telephone only
		pattern = Pattern.compile(telephoneRegex);
		m = pattern.matcher(telephone);
		
		if (!m.find()) {
			flag = false;
			telephone = "wrong telephone format";
		} else {
			User user = userDAO.findByTelephone(telephone);
			if (user != null) {
				flag = false;
				telephone = "this telephone already exists";
			}
		}
		
		//check email only
		pattern = Pattern.compile(emailRegex);
		m = pattern.matcher(email);
			
		if (!m.find()) {
			flag = false;
			email = "wrong email format";
		} else {
			User user = userDAO.findByEmail(email);
			if (user != null) {
				flag = false;
				email = "this email already exists";
			}
		}
		
		User reUser  = new User(username, password, telephone, email);
		reUser.setId(-1);
		if (flag) {
			reUser.setId(userDAO.insert(reUser));
		}
		
		return reUser;
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
	
	public User getInfo(int userId) {
		return userDAO.findByID(userId);
	}
	
}
