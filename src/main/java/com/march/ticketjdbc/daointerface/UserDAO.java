package com.march.ticketjdbc.daointerface;

import java.util.List;

import com.march.ticketjdbc.model.User;



public interface UserDAO {
	public List<User> findAll();
	public User findByName(String userName);
	public User findByID(int id);
	public User findByTelephone(String telephone);
	public User findByEmail(String email);
	public int insert(User user);
	public int update(User user);
	public int delete(int userId);
}
