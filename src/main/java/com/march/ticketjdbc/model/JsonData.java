package com.march.ticketjdbc.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonData {
	
	@JsonView(JsonModule.DefaultModule.class)
	private String error_code;

	@JsonView({JsonModule.GetMovieListModule.class, JsonModule.GetCinemaListModule.class, JsonModule.GetSessionListModule.class})
	private List<Object> list;

	@JsonView(JsonModule.CreateOrderModule.class)
	private Orders order;
	
	@JsonView({JsonModule.CreateOrderModule.class, JsonModule.GetSessionInfoModule.class})
	private Seat seat;

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
