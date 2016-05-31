package com.march.ticketjdbc.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.march.ticketjdbc.service.OrderService;
import com.march.ticketjdbc.daoImpl.OrderDAOImpl;
import com.march.ticketjdbc.model.Orders;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private OrderDAOImpl orderDAO;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
			System.out.println("ticketjdbc server started!!!!!!!");

			List<Orders> notPaidOrders = orderDAO.findOrdersState("1");
			OrderService.checkOrderList = notPaidOrders;
	}
}
