package com.march.ticketjdbc.service;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.march.ticketjdbc.daoImpl.*;
import com.march.ticketjdbc.model.*;

@Service
public class OrderService {
	@Autowired
	private TicketDAOImpl ticketDAO;
	
	@Autowired
	private SessionDAOImpl sessionDAO;
	
	@Autowired
	private OrderDAOImpl orderDAO;
	
	public boolean checkSeats(int sessionId, String seats) {
		String []Seats_str = seats.split(",");
		List<Integer> Seats_int = new ArrayList<Integer>();
		for (String str : Seats_str) {
			Seats_int.add(Integer.parseInt(str));
		}
		
		List<Ticket> soldTickets = ticketDAO.findBySession(sessionId);		
		Collections.sort(Seats_int);
		Collections.sort(soldTickets);
		
		if (soldTickets.size() == 0)
			return true;	//该场次暂无已售票
		if (Seats_int.size() == 0)
			return false;	//无选座
		
		int i = 0, j = 0;
		while (i < Seats_int.size() && j < soldTickets.size()) {
			if (Seats_int.get(i).equals(soldTickets.get(j)))
				return false;
			int a = Seats_int.get(i);
			int b = Seats_int.get(j);
			if (a < b) i++;
			else j++;
		}
				
		return true;
	}
	
	public Orders createOrder(int userId, int cinemaId, int sessionId, String seats) {
		//创建订单
		Long now = System.currentTimeMillis();
		Session session = sessionDAO.findByID(sessionId);
		String []Seat_str = seats.split(",");
		
		Orders order = new Orders(userId, cinemaId, now, session.getPrice() * Seat_str.length, OrderState.NOT_PAID);
		order.setId(orderDAO.insert(order));
		
		//锁定已选票
		for (String str: Seat_str) {
			ticketDAO.insert(new Ticket(order.getId(), Integer.parseInt(str),session.getPrice(), sessionId));
		}
		
		return order;
	}
}
