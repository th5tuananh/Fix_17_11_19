package com.lhq.postmanagermentservice.model;


public class Favorite {
	
	private Long favo_id;
	private String user_id;
	private int post_id;
	
	public Favorite() {}
	public Favorite(Long favo_id, String user_id, int post_id) {
		super();
		this.favo_id = favo_id;
		this.user_id = user_id;
		this.post_id = post_id;
	}
	public Long getFavo_id() {
		return favo_id;
	}
	public void setFavo_id(Long favo_id) {
		this.favo_id = favo_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	
	
}

