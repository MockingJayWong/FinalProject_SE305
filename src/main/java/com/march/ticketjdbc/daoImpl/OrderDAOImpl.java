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

import com.march.ticketjdbc.daointerface.OrderDAO;
import com.march.ticketjdbc.model.Orders;

public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//锟�?鑸笉浼氱敤锟�?
	@Override
	public List<Orders> findAll() {
		return jdbcTemplate.query("select * from orders", new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public int insert(final Orders order) {
		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into orders values(null,?,?,?,?,?)", new String[]{"id"});
				st.setInt(1, order.getUserID());
				st.setInt(2, order.getCinemaID());
				st.setLong(3, order.getTime());
				st.setFloat(4, order.getPrices());
				st.setString(5, order.getState());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}

	@Override
	public int update(int id, String orderstate) {
		return jdbcTemplate.update("update orders set state = ? where id = ?",
				new Object[] {orderstate,id});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from user where id =" + id + "");
	}
	


////////////////////////////////////////////////////

	@Override
	public List<Orders> findByUserId(int Id) {
		return jdbcTemplate.query("select * from orders where userID = ?",new Object[]{Id}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public List<Orders> findByUserIdIdAndState(int Id, String orderstate) {
		return jdbcTemplate.query("select * from orders where userID = ? and state = ?",
				new Object[]{Id, orderstate}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public List<Orders> findByUserIdIdAndData(int Id, long startTime, long endTime) {
		return jdbcTemplate.query("select * from orders where userID = ? and time >= ? and time <= ?",
				new Object[]{Id, startTime, endTime}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public List<Orders> findByCinemaId(int Id) {
		return jdbcTemplate.query("select * from orders where cinemaID = ?",new Object[]{Id}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public List<Orders> findByCinemaIdIdAndState(int Id,  String orderstate) {
		return jdbcTemplate.query("select * from orders where cinemaID = ? and state = ?",
				new Object[]{Id, orderstate}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public List<Orders> findByCinemaIdIdAndData(int Id, long startTime, long endTime) {
		return jdbcTemplate.query("select * from orders where cinemaID = ? and time >= ? and time <= ?",
				new Object[]{Id, startTime, endTime}, new BeanPropertyRowMapper<Orders>(Orders.class));
	}


}
