package com.niit.colloboration_backendModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
	@Table(name = "USER")
	@Component
	public class User extends ErrorMessages implements Serializable
	{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "USERID")
		private int user_id;
		
		
		@Column(name = "UserName",unique=true, nullable = false)
		private String username;
		
		
		@Column(name = "FirstName", nullable = false)
		private String first_name;
		
		
		@Column(name = "LastName", nullable = false)
		private String last_name;
		
		@Column(name = "Gender", nullable = false)
		private String gender;
		
		@Column(name = "Contact", nullable = false)
		private String contact;
		
		@Column(name= "Email_ID", unique=true,nullable=false)
		private String email_id;
		
		@Column(name= "Place", nullable=false)
		private String place; 
		
		@Column(name = "Password", nullable = false)
		private String password;
		
		@Column(name = "Role", nullable = false)
		 private String role;
		
		@Column(name = "Isonline", nullable = false)
		 private String isonline;
		
		@Column(name="Status")
		private String status;
		
		@Column(name = "image")
	    private String image;

		@Column(name = "cover")
	    private String cover;

		



		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}	

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getIsonline() {
			return isonline;
		}

		public void setIsonline(String isonline) {
			this.isonline = isonline;
		}

		

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}	

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
		
		
		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getCover() {
			return cover;
		}

		public void setCover(String cover) {
			this.cover = cover;
		}

		@Override
		public String toString() {
			return "User [User_ID=" + user_id + ", username=" + username + ", first_name=" + first_name + ", last_name="
					+ last_name + ", gender=" + gender + ", contact=" + contact + ", email_id=" + email_id + ", password="
					+ password + ", role=" + role + ", isonline=" + isonline + ", status=" + status + "]";
		}

		
		
		
		
		


		 
		 
		
		

	}

