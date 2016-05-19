package com.march.ticketjdbc.dao;

import java.util.Collection;

import com.march.ticketjdbc.model.User;



public interface UserDAO {
	public Collection<User> findAll();
	public User findByName(String userName);
	public User findByID(int id);
	public int insert(User user);
	public int update(User user);
	public int delete(int userId);
}
