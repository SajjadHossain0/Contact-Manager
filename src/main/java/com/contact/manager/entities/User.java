package com.contact.manager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	@NotBlank(message = "Name field is required...")
	private String user_name;
	@Column(unique = true)
	@NotBlank(message = "Email field is required...")
	private String user_email;
	@Column(unique = true)
	@NotBlank(message = "Username field is required...")
	private String user_username;
	@NotBlank(message = "Password field is required...")

	private String user_password;
	private String user_image_url;
	@Column(length = 500)
	private String user_about;
	private String user_role;
	private boolean user_active;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Contact> contact = new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String user_name, String user_email, String user_username, String user_password,
			String user_image_url, String user_about, String user_role, boolean user_active, List<Contact> contact) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_image_url = user_image_url;
		this.user_about = user_about;
		this.user_role = user_role;
		this.user_active = user_active;
		this.contact = contact;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_image_url() {
		return user_image_url;
	}

	public void setUser_image_url(String user_image_url) {
		this.user_image_url = user_image_url;
	}

	public String getUser_about() {
		return user_about;
	}

	public void setUser_about(String user_about) {
		this.user_about = user_about;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public boolean isUser_active() {
		return user_active;
	}

	public void setUser_active(boolean user_active) {
		this.user_active = user_active;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", user_email='" + user_email + '\'' +
				", user_username='" + user_username + '\'' +
				", user_password='" + user_password + '\'' +
				", user_image_url='" + user_image_url + '\'' +
				", user_about='" + user_about + '\'' +
				", user_role='" + user_role + '\'' +
				", user_active=" + user_active +
				", contact=" + contact +
				'}';
	}
}
