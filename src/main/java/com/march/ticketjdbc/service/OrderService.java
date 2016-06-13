package com.march.ticketjdbc.service;

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
	
	
	private OrderDAOImpl orderDAO;
	
	private List<Orders> checkOrderList;
	
	@Autowired
	public OrderService(OrderDAOImpl orderDAO) {
		this.orderDAO = orderDAO;
		checkOrderList = Collections.synchronizedList(orderDAO.findOrdersState("1"));
	}
	
	private final long effectiveTime = 15 * 60 * 1000;
	
	public boolean checkSeats(int sessionId, String seats) {
		String []Seats_str = seats.split(",");

		List<Integer> Seats_int = new ArrayList<Integer>();
		for (String str : Seats_str) {
			String []Seats_xy = str.split("_");
			Seats_int.add( (Integer.parseInt(Seats_xy[0])  - 1) * 11+ Integer.parseInt(Seats_xy[1] )  - 1);
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
			if (Seats_int.get(i).equals(soldTickets.get(j).getSeat())) {
				
				return false;
			}
			int a = Seats_int.get(i);
			int b = soldTickets.get(j).getSeat();
			if (a < b) i++;
			else j++;
		}

		return true;
	}
	
	public Orders createOrder(int userId, int cinemaId, int sessionId, String seats) {
		//创建订单
		long now = System.currentTimeMillis();
		Session session = sessionDAO.findByID(sessionId);
		String []Seat_str = seats.split(",");
		
		Orders order = new Orders(userId, cinemaId, now, session.getPrice() * Seat_str.length, "1");
		order.setId(orderDAO.insert(order));
		checkOrderList.add(order);
		
		//锁定已选票
		for (String str: Seat_str) {
			String []Seats_xy = str.split("_");
			int s = (Integer.parseInt(Seats_xy[0])  - 1) * 11+ Integer.parseInt(Seats_xy[1] )  - 1;
			ticketDAO.insert(new Ticket(order.getId(), s, session.getPrice(), sessionId));
		}
		return order;
	}
	
	public Orders getOrderDetail(int orderId) {
		return orderDAO.findByOrderId(orderId);
	}

	public Session getSessionByOrderId(int orderId) {
		List<Ticket> tickets = ticketDAO.findByOrder(orderId);
		if (tickets.size() == 0) {
			return null;
		} else {
			return sessionDAO.findByID(tickets.get(0).getSessionID());
		}
	}
	
	public void checkOrder() {
		/*
		if (!checkOrderList.isEmpty()) {
			Orders order = checkOrderList.get(0);

			Date now = new Date(System.currentTimeMillis());
			Date createOrderTime = new Date(order.getTime());
			long length = now.getTime() - createOrderTime.getTime();

			if (length > effectiveTime) {
				orderDAO.update(order.getId(), "2");
				checkOrderList.remove(0);
			}
		}*/
		synchronized(checkOrderList) {
			Iterator<Orders> iter = checkOrderList.iterator();
			while (iter.hasNext()) {
				Orders order = iter.next();
				if (order.getTime() + effectiveTime > System.currentTimeMillis()) {
					break;
				}
				if (orderDAO.findByOrderId(order.getId()).getState().equals("1")) {
					orderDAO.update(order.getId(), "2");
				}
				//票解锁
				ticketDAO.deleteByOrderID(order.getId());
				iter.remove();
			}
		}
	}

	public List<Orders> getCheckOrderList() {
		return checkOrderList;
	}
	
	public int UpdateOrderState(int orderid, String state) {
		return orderDAO.update(orderid, state);
	}
	
	public List<Orders> getOrderList(int userId) {
		checkOrder();
		return orderDAO.findByUserId(userId);
	}
}
