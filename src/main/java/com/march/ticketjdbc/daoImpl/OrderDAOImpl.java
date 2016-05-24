package com.march.ticketjdbc.daoImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.march.ticketjdbc.daointerface.OrderDAO;
import com.march.ticketjdbc.model.Orders;

public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//�?般不会用�?
	@Override
	public List<Orders> findAll() {
		return jdbcTemplate.query("select * from orders", new BeanPropertyRowMapper<Orders>(Orders.class));
	}



	@Override
	public int insert(Orders order) {
		return jdbcTemplate.update("insert into orders values(null,?,?,?,?,?)",
				new Object[] {order.getUserID(),order.getCinemaID(),order.getTime(),
						order.getPrices(),"1"});
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
