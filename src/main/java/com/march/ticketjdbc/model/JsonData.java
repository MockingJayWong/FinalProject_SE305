package com.march.ticketjdbc.model;

import java.util.Collection;
import java.util.List;

public class JsonData {
	private int error_code;
	private Collection<?> list;
	private Object object;
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public Collection<?> getList() {
		return list;
	}
	public void setList(Collection<?> list) {
		this.list = list;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
