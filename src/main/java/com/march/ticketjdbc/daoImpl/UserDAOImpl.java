package com.march.ticketjdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.march.ticketjdbc.daointerface.UserDAO;
import com.march.ticketjdbc.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findByName(String userName) {
		return jdbcTemplate.queryForObject("select * from user where username = ?",
				new BeanPropertyRowMapper<User>(User.class), userName);
	}

	@Override
	public int insert(final User user) {
		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into user values(null,?,?,?,?)", new String[]{"id"});
				st.setString(1, user.getUsername());
				st.setString(2, user.getPassword());
				st.setString(3, user.getTelephone());
				st.setString(4, user.getEmail());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
		// TODO Auto-generated method stub

	}

	@Override
	public int update(User user) {
		return jdbcTemplate.update("update user set password = ?,telephone = ?, email = ?, where id = ?",
				new Object[] {user.getPassword(),
						user.getTelephone(),user.getEmail(),user.getId()});
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
