package com.lhq.postmanagermentservice.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class PostRent extends RepresentationModel {

	private Long post_id;
	private String user_id;
	private String catalog;
	private String title;
	private String content;
	private int price;
	private int area;
	private String thumbnail;
	private String image_url;
	private String city;
	private String district;
	private String address;
	private String location;
	private String certification;
	private int rating;
	private List<String> ulti;
	
	public PostRent(Long post_id, String user_id, String catalog, String title, String content, int price, int area,
			String thumbnail, String image_url, String city, String district, String address, String location,
			int rating, List<String> ulti) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.catalog = catalog;
		this.title = title;
		this.content = content;
		this.price = price;
		this.area = area;
		this.thumbnail = thumbnail;
		this.image_url = image_url;
		this.city = city;
		this.district = district;
		this.address = address;
		this.location = location;
		this.rating = rating;
		this.ulti = ulti;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getUlti() {
		return ulti;
	}

	public void setUlti(List<String> ulti) {
		this.ulti = ulti;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
	
	
	
}
