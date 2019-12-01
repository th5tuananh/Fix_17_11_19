package com.lhq.postmanagermentservice.model;

public class PostHouse {
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
	private String direction;
	private int rating;
	private String house_level;
	private int floor;
	private int restroom;
	private int bedroom;
	
	public PostHouse() {}
	public PostHouse(Long post_id, String user_id, String catalog, String title, String content, int price, int area,
			String thumbnail, String image_url, String city, String district, String address, String location, String certification,
			String direction, int rating, String house_level, int floor, int restroom, int bedroom) {
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
		this.certification = certification;
		this.direction = direction;
		this.rating = rating;
		this.house_level = house_level;
		this.floor = floor;
		this.restroom = restroom;
		this.bedroom = bedroom;
	}
	public Long getPost_id() {
		return post_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getCatalog() {
		return catalog;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getPrice() {
		return price;
	}
	public int getArea() {
		return area;
	}
	public String getImage_url() {
		return image_url;
	}
	public String getCity() {
		return city;
	}
	public String getDistrict() {
		return district;
	}
	public String getAddress() {
		return address;
	}
	public String getLocation() {
		return location;
	}
	public String getCertification() {
		return certification;
	}
	public String getDirection() {
		return direction;
	}
	public int getRating() {
		return rating;
	}
	public String getHouse_level() {
		return house_level;
	}
	public int getFloor() {
		return floor;
	}
	public int getRestroom() {
		return restroom;
	}
	public int getBedroom() {
		return bedroom;
	}
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setHouse_level(String house_level) {
		this.house_level = house_level;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public void setRestroom(int restroom) {
		this.restroom = restroom;
	}
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
}
