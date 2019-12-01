package com.lhq.ultilityservice.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ultilities")
@EntityListeners(AuditingEntityListener.class)
public class Ultility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
