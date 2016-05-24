package com.march.ticketjdbc.daointerface;

import java.sql.Date;
import java.util.List;

import com.march.ticketjdbc.model.Orders;


public interface OrderDAO {
	public List<Orders> findAll();
	public List<Orders> findByUserId(int Id);
	public List<Orders> findByUserIdIdAndState(int Id, String orderstate);
	
	//注意这里的Data是sql包中
	public List<Orders> findByUserIdIdAndData(int Id, long startTime , long endTime);
	
	public List<Orders> findByCinemaId(int Id);
	public List<Orders> findByCinemaIdIdAndState(int Id, String orderstate);
	
	//注意这里的Data是sql包中
	public List<Orders> findByCinemaIdIdAndData(int Id, long startTime , long endTime);
	
	
	public int insert(Orders order);
	
	//按常理，订单修改只能修改其状态�??
	public int update(int id, String orderstate);
	public int delete(int id);
}
