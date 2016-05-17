package com.example.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<User> findAll() {
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findByName(String userName) {
		return jdbcTemplate.queryForObject("select * from user where username = ?",
				new BeanPropertyRowMapper<User>(User.class), userName);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into user values(null,?,?,?,?,?)",
				new Object[] {user.getUsername(),user.getPassword(),
						user.getTelephone(),user.getEmail(),user.getRole()});
	}

	@Override
	public int update(User user) {
		return jdbcTemplate.update("update user set password = ?,telephone = ?, email = ?, role = ? where id = ?",
				new Object[] {user.getPassword(),
						user.getTelephone(),user.getEmail(),user.getRole(),user.getId()});
	}

	@Override
	public int delete(int userId) {
		return jdbcTemplate.update("delete from user where id =" + userId + "");
	}

	@Override
	public User findByID(int userId) {
		return jdbcTemplate.queryForObject("select * from user where id = ?",
				new BeanPropertyRowMapper<User>(User.class), userId);
		
	}

}
