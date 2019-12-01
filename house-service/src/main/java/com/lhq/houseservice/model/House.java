package com.lhq.houseservice.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "houses1")
@EntityListeners(AuditingEntityListener.class)
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long house_id;
	private String user_id;
	private String house_name;
	private String house_level;
	private int floor;
	private int restroom;
	private int bedroom;
	private String image_url;
	private String address;
	private String direction;
	
	public House() {
		
	}
	

	public House(Long house_id, String user_id, String house_level, int floor, int restroom, int bedroom,
			String image_url, String address, String direction) {
		super();
		this.house_id = house_id;
		this.user_id = user_id;
		this.house_level = house_level;
		this.floor = floor;
		this.restroom = restroom;
		this.bedroom = bedroom;
		this.image_url = image_url;
		this.address = address;
		this.direction = direction;
	}

	public Long getHouse_id() {
		return house_id;
	}

	public String getUser_id() {
		return user_id;
	}


	public String getHouse_level() {
		return house_level;
	}

	public int getRestroom() {
		return restroom;
	}

	public int getBedroom() {
		return bedroom;
	}

	public int getFloor() {
		return floor;
	}

	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setHouse_level(String house_level) {
		this.house_level = house_level;
	}

	public void setRestroom(int restroom) {
		this.restroom = restroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public String getHouse_name() {
		return house_name;
	}


	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}



	
	
	
	
}

