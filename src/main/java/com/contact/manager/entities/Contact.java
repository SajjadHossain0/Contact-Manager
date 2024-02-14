package com.contact.manager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_details")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contact_id;
	private String contact_name;
	private String contact_nickname;
	@Column(unique = true)
	private String contact_email;
	private String contact_number;
	@Column(length = 500)
	private String contact_work;
	private String contact_about;
	private String contact_image_url;
	@ManyToOne
	private User user;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contact_id, String contact_name, String contact_nickname, String contact_email,
			String contact_number, String contact_work, String contact_about, String contact_image_url, User user) {
		super();
		this.contact_id = contact_id;
		this.contact_name = contact_name;
		this.contact_nickname = contact_nickname;
		this.contact_email = contact_email;
		this.contact_number = contact_number;
		this.contact_work = contact_work;
		this.contact_about = contact_about;
		this.contact_image_url = contact_image_url;
		this.user = user;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_nickname() {
		return contact_nickname;
	}

	public void setContact_nickname(String contact_nickname) {
		this.contact_nickname = contact_nickname;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getContact_work() {
		return contact_work;
	}

	public void setContact_work(String contact_work) {
		this.contact_work = contact_work;
	}

	public String getContact_about() {
		return contact_about;
	}

	public void setContact_about(String contact_about) {
		this.contact_about = contact_about;
	}

	public String getContact_image_url() {
		return contact_image_url;
	}

	public void setContact_image_url(String contact_image_url) {
		this.contact_image_url = contact_image_url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	

}
