package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.*;

import net.sf.json.JSONObject;

import com.example.dao.*;

@Service
public class UserService {
	@Autowired
	private UserDAOImpl UserDAO;
	
	public Object Sign(String username, String password, String telephone, String email) {
		String message = null;
		
		User user = UserDAO.findByName(username);
		if (user == null) {
			UserDAO.insert(new User(username, password, telephone, email));
		} else {
			message = "this username has been signed";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		message = message == null ? "success" : message;
		map.put("status", message);
		return JSONObject.fromObject(map);
	}
	
	public Object Login(String username, String password) {
		String message = "no this username";
		
		User user = UserDAO.findByName(username);
		if (user == null) {
			if (user.getPassword().equals(password)) {
				message = "success";
			} else {
				message = "password error";
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", message);
		return JSONObject.fromObject(map);
	}
	
	public Object Change(String username, String password, String telephone, String email) {
		String message = "success";
		
		User user = UserDAO.findByName(username);
		if (password == null || password.length() == 0) {
			message = "password can not be blank";
		} else {
			if (telephone == null || telephone.length() == 0) {
				user.setTelephone("");
			} else {
				user.setTelephone(telephone);
			}
			
			if (email == null || email.length() == 0) {
				user.setEmail("");
			} else {
				user.setEmail(email);
			}
			UserDAO.update(user);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", message);
		return JSONObject.fromObject(map);
	}
}
