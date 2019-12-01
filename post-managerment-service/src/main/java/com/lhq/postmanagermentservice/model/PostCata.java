package com.lhq.postmanagermentservice.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "posts1")
@EntityListeners(AuditingEntityListener.class)
public class PostCata extends RepresentationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long post_id;
		private String user_id;
		private String title;
		private int price;
		private String thumbnail;
		private String catalog;
		private String city;
		private String district;
		private String create_at;
		
		public PostCata() {}


		public PostCata(Long post_id, String user_id, String title, int price, String thumbnail, String catalog,
				String city, String district, String create_at) {
			super();
			this.post_id = post_id;
			this.user_id = user_id;
			this.title = title;
			this.price = price;
			this.thumbnail = thumbnail;
			this.catalog = catalog;
			this.city = city;
			this.district = district;
			this.create_at = create_at;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	

		public String getThumbnail() {
			return thumbnail;
		}



		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}



		public String getCatalog() {
			return catalog;
		}

		public void setCatalog(String catalog) {
			this.catalog = catalog;
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


		public String getCreate_at() {
			return create_at;
		}


		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

	
		
		
}
