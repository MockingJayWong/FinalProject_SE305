package com.example.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JsonDatas.OrderServiceJsonData;
import com.example.dao.*;
import com.example.model.*;

import net.sf.json.JSONObject;

@Service
public class OrderService {
	@Autowired
	private TicketImpl TicketDAO;
	
	@Autowired
	private SeatListDAOImpl SeatListDAO;
	
	@Autowired
	private cinemaSessionDAOImpl cinemaSessionDAO;
	
	@Autowired
	private OrderDAOImpl OrderDAO;
	
	@Autowired
	private cinemaDAOImpl CinemaDAO;
	
	public Object createOrder(int userID, int cinemaID, int sectionID, String seats) {
		String message = null;
		
		//将座位字符串转为Integer型
		String []Seats_str = seats.split(",");
		List<Integer> seats_int = new ArrayList<Integer>();
		for (String str: Seats_str) {
			seats_int.add(Integer.parseInt(str));
		}
		
		Collection<Ticket> soldTickets = TicketDAO.findBySession(sectionID);	//获取已锁定票
		Session section = cinemaSessionDAO.findByID(sectionID);		//获取电影场次
		if (soldTickets.size() == 0) {
			message = "请选择座位";
		}
		
		if (message == null) {
			for (Integer seat : seats_int) {
				for (Ticket ticket : soldTickets) {
					if (seat == ticket.getSeat()) {
						message = "选中座位已有被售票";
					}
				}
			}
		}
		
		Orders order = new Orders();
		if (message == null) {
			//更新数据库座位表信息，若已存在改场次电影的座位表情况，则更新，否则添加
			Seat s = SeatListDAO.findBySessionId(sectionID);
			if (s.equals(null)) {
				SeatListDAO.insert(new Seat(sectionID, seats));
			} else {
				SeatListDAO.update(new Seat(sectionID, s.getSold_list() + seats));
			}
			
			//创建订单
			Date now = new Date(System.currentTimeMillis());
			order = new Orders(userID, cinemaID, now, section.getPrice() * seats_int.size(), OrderState.NOT_PAID);
			order.setId(OrderDAO.insert(order));
			
			//添加锁定票
			for (Integer seat : seats_int) {
				TicketDAO.insert(new Ticket(order.getId(), seat, section.getPrice(), sectionID));
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (message == null) {
			message = "success";
			
			//生成返回数据对象
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime = format.format(section.getStart_time());
			String endTime = format.format(section.getEnd_time());
			
			Cinema cinema = CinemaDAO.findById(cinemaID);
			
			//座位格式转换
			String Seats[] = new String[seats_int.size()];
			for (int i = 0; i < seats_int.size(); i++) {
				Seats[i] = Integer.toString(seats_int.get(i) / 10) + "," + Integer.toString(seats_int.get(i) % 10);
			}
			
			OrderServiceJsonData jsonData = new OrderServiceJsonData(order.getId(),startTime,endTime, cinema.getCinemaName(), Seats, section.getPrice() * seats_int.size()); 
			map.put("data", jsonData);
			
		} else {
			message = "failed";
		}
		
		map.put("status", message);
		
		return JSONObject.fromObject(map);
	}
}
