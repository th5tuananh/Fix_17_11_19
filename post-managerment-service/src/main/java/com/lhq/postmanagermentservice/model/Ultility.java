package com.lhq.postmanagermentservice.model;

public class Ultility {

	private Long ulti_id;
	private int house_id;
	private String name;
	private String description;
	public Ultility() {}
	
	public Ultility(Long ulti_id, int house_id, String name, String description) {
		super();
		this.ulti_id = ulti_id;
		this.house_id = house_id;
		this.name = name;
		this.description = description;
	}

	public Long getUlti_id() {
		return ulti_id;
	}

	public void setUlti_id(Long ulti_id) {
		this.ulti_id = ulti_id;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
