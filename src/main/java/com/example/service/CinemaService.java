package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.*;
import com.example.model.*;

import net.sf.json.JSONObject;

@Service
public class CinemaService {
	@Autowired
	private cinemaDAOImpl CinemaDAO;
	
	public Object Sign(String username, String password, String telephone, String email, String cinemaName, String address) {
		String message = null;
		
		Cinema cinema = CinemaDAO.findByName(username);
		if (cinema == null) {
			CinemaDAO.insert(new Cinema(cinemaName, address, username, password, telephone, email));
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
		
		Cinema cinema = CinemaDAO.findByName(username);
		if (cinema == null) {
			if (cinema.getPassword().equals(password)) {
				message = "success";
			} else {
				message = "password error";
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", message);
		return JSONObject.fromObject(map);
	}
	
	public Object Change(String username, String password, String telephone, String email, String cinemaName, String address) {
		String message = "success";
		
		Cinema cinema = CinemaDAO.findByName(username);
		if (password == null || password.length() == 0) {
			message = "password can not be blank";
		} else {
			if (telephone == null || telephone.length() == 0) {
				cinema.setTelephone("");
			} else {
				cinema.setTelephone(telephone);
			}
			
			if (email == null || email.length() == 0) {
				cinema.setEmail("");
			} else {
				cinema.setEmail(email);
			}
			
			if (cinemaName == null || cinemaName.length() == 0) {
				message = "cinema\'s name can not be blank";
			} else {
				cinema.setCinemaName(cinemaName);
			}
			
			if (address == null || address.length() == 0) {
				message = "cinema\'s address can not be blank";
			} else {
				cinema.setAddress(address);
			}
			
			if (message.equals("success")) {
				CinemaDAO.update(cinema);
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", message);
		return JSONObject.fromObject(map);
	}
}
