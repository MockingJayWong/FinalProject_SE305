package com.example.model;

public enum OrderState {
	PAID('0'), NOT_PAID('1'), INVALID('2');
	
	private final char context;

	private char getContext() {
		return context;
	}
	
	private OrderState(char cont) {
		context = cont;
	}
	
	@Override
	public String toString() {
		return "" + getContext();
	}
}
