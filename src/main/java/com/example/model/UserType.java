package com.example.model;

public enum UserType {
	Consumer('0'), Cinema('1');
	
	private final char context;

	private char getContext() {
		return context;
	}
	
	private UserType(char cont) {
		context = cont;
	}
	
	@Override
	public String toString() {
		return "" + getContext();
	}
}
