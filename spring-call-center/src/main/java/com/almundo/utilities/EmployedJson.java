package com.almundo.utilities;

public class EmployedJson {
	
	private String name;
	private EmployedTypeEnum type;
	private boolean available;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployedTypeEnum getType() {
		return type;
	}
	public void setType(EmployedTypeEnum type) {
		this.type = type;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
