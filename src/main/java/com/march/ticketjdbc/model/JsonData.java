package com.march.ticketjdbc.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonData {
	
	//wujiahui
	@JsonView({JsonModule.GetSessionListModule.class, JsonModule.DefaultModule.class,JsonModule.GetSessionInfoModule.class})
	private String error_code;

	//wujiahui
	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetSessionInfoModule.class,
		JsonModule.GetCinemaListModule.class, JsonModule.GetSessionListModule.class})
	private List<Object> list;

	@JsonView(JsonModule.CreateOrderModule.class)
	private Orders order;
	
	//wujiahui
	@JsonView(JsonModule.CreateOrderModule.class)
	private Seat seat;
	
	//wujiahui
	@JsonView(JsonModule.GetSessionInfoModule.class)
	private int h;
	
	//wujiahui
	@JsonView(JsonModule.GetSessionInfoModule.class)
	private int w;
	//wujiahui
	public int getH() {
		return h;
	}
	
	//wujiahui
	public void setH(int h) {
		this.h = h;
	}
	
	//wujiahui
	public int getW() {
		return w;
	}
	//wujiahui
	public void setW(int w) {
		this.w = w;
	}

	public JsonData() {
		list = new ArrayList<Object>();
	}

	public String getError_code() {
		return error_code;
	}
	
	public void setError_code(String code) {
		error_code = code;
	}

	public List<Object> getList() {
		return list;
	}
	
	public <T> void setList(List<T> tlist) {
		list.clear();
		if (tlist != null) {
			list.addAll(tlist);
		}
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
