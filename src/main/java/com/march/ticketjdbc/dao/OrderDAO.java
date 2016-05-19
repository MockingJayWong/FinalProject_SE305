package com.march.ticketjdbc.dao;

import java.sql.Date;
import java.util.Collection;

import com.march.ticketjdbc.model.OrderState;
import com.march.ticketjdbc.model.Orders;


public interface OrderDAO {
	public Collection<Orders> findAll();
	public Collection<Orders> findByUserId(int Id);
	public Collection<Orders> findByUserIdIdAndState(int Id, OrderState orderstate);
	
	//注意这里的Data是sql包中
	public Collection<Orders> findByUserIdIdAndData(int Id, Date startTime , Date endTime);
	
	public Collection<Orders> findByCinemaId(int Id);
	public Collection<Orders> findByCinemaIdIdAndState(int Id, OrderState orderstate);
	
	//注意这里的Data是sql包中
	public Collection<Orders> findByCinemaIdIdAndData(int Id, Date startTime , Date endTime);
	
	
	public int insert(Orders order);
	
	//按常理，订单修改只能修改其状态�??
	public int update(int id, OrderState orderstate);
	public int delete(int id);
}
