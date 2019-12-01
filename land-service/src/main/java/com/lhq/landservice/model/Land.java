package com.lhq.landservice.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "lands1")
@EntityListeners(AuditingEntityListener.class)
public class Land {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long land_id;
	private String user_id;
	private String image_url;
	private String address;
	private String direction;
	private String facade_area;
	
	
	public Land() {
		
	}


	


	public Land(Long land_id, String user_id, int post_id, String image_url, String address, String direction,
			String facade_area) {
		super();
		this.land_id = land_id;
		this.user_id = user_id;
		this.image_url = image_url;
		this.address = address;
		this.direction = direction;
		this.facade_area = facade_area;
	}





	public Long getLand_id() {
		return land_id;
	}





	public void setLand_id(Long land_id) {
		this.land_id = land_id;
	}





	public String getUser_id() {
		return user_id;
	}





	public void setUser_id(String user_id) {
		this.user_id = user_id;
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





	public String getFacade_area() {
		return facade_area;
	}





	public void setFacade_area(String facade_area) {
		this.facade_area = facade_area;
	}




}