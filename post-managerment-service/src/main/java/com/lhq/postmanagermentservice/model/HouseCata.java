package com.lhq.postmanagermentservice.model;

import org.springframework.hateoas.RepresentationModel;

public class HouseCata extends RepresentationModel<HouseCata>{
	private Long house_id;
	private String house_name;
	private String address;
	
	
	public HouseCata() {}
	public HouseCata(Long house_id, String house_name, String address) {
		super();
		this.house_id = house_id;
		this.house_name = house_name;
		this.address = address;
	}
	public Long getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
