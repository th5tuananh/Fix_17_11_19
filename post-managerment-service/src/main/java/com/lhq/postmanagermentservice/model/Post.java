package com.lhq.postmanagermentservice.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "posts1")
@EntityListeners(AuditingEntityListener.class)
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long post_id;
	private String user_id;
	private int house_id;
	private int land_id;
	private String catalog;
	private String title;
	private String content;
	private int price;
	private String thumbnail;
	private int area;
	private String city;
	private String district;
	private String location;
	private String certification;
	private int rating;
	private String status;
	
	public Post() {}
	

	public Post(Long post_id, String user_id, int house_id, int land_id, String catalog, String title, String content, int price, String thumbnail,
			int area, String city, String district, String location, String certification, int rating, String status) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.house_id = house_id;
		this.land_id =land_id;
		this.catalog = catalog;
		this.title = title;
		this.content = content;
		this.price = price;
		this.thumbnail = thumbnail;
		this.area = area;
		this.city = city;
		this.district = district;
		this.location = location;
		this.certification = certification;
		this.rating = rating;
		this.status = status;
	}



	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


	public int getHouse_id() {
		return house_id;
	}


	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}


	public int getLand_id() {
		return land_id;
	}


	public void setLand_id(int land_id) {
		this.land_id = land_id;
	}


	
	
	
}
