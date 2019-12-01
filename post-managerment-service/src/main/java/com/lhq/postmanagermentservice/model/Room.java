package com.lhq.postmanagermentservice.model;


public class Room {
	
	private Long room_id;
	private int house_id;
	private String room_name;
	private int day_price;
	private int month_price;
	private String status;
	
	public Room() {}
	public Room(Long room_id, int house_id, String room_name, int day_price, int month_price, String status) {
		super();
		this.room_id = room_id;
		this.house_id = house_id;
		this.room_name = room_name;
		this.day_price = day_price;
		this.month_price = month_price;
		this.status = status;
	}

	public Long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getDay_price() {
		return day_price;
	}

	public void setDay_price(int day_price) {
		this.day_price = day_price;
	}

	public int getMonth_price() {
		return month_price;
	}

	public void setMonth_price(int month_price) {
		this.month_price = month_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

