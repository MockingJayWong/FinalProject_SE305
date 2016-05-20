package com.march.ticketjdbc.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonData {

	// Represents all modules
	public interface DefaultModule {
	}

	// Represents modules that only return status and a list
	public interface GetListModule extends DefaultModule {
	}
	
	// Represents the order module
	public interface OrderModule extends DefaultModule {
	}

	// Represents the section info module
	public interface SectionInfoModule extends DefaultModule {
	}

	@JsonView(JsonData.DefaultModule.class)
	private String error_code;

	@JsonView(JsonData.GetListModule.class)
	private List<Object> list;

	@JsonView(JsonData.SectionInfoModule.class)
	private int h;

	@JsonView(JsonData.SectionInfoModule.class)
	private int w;

	@JsonView(JsonData.SectionInfoModule.class)
	private List<Integer> positions;

	@JsonView(JsonData.OrderModule.class)
	private String orderId;

	@JsonView(JsonData.OrderModule.class)
	private String startTime;

	@JsonView(JsonData.OrderModule.class)
	private String endTime;

	@JsonView(JsonData.OrderModule.class)
	private String cinemaName;

	@JsonView(JsonData.OrderModule.class)
	private List<Integer> seats;

	@JsonView(JsonData.OrderModule.class)
	private float total;


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

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public List<Integer> getPositions() {
		return positions;
	}

	public void setPositions(List<Integer> positions) {
		this.positions = positions;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
