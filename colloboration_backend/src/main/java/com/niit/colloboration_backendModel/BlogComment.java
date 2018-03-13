package com.niit.colloboration_backendModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BlogComment")
	public class BlogComment 
	{
		@Id
	    @GeneratedValue 
	    @Column(name = "BlogcomId", nullable = false)
		private int blogcomid;
		
		@Column(name = "BlogComm", nullable = false)
	    private String blogcomm;
		


		@Column(name = "Blogid", nullable = false)
		private int blogid;
		
		@Column(name = "Userid", nullable = false)
		private int User_ID;
		
		@Column(name = "Username", nullable = false)
		private String username;


		

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getBlogcomid() {
			return blogcomid;
		}

		public void setBlogcomid(int blogcomid) {
			this.blogcomid = blogcomid;
		}

		public String getBlogcomm() {
			return blogcomm;
		}

		public void setBlogcomm(String blogcomm) {
			this.blogcomm = blogcomm;
		}

		public int getBlogid() {
			return blogid;
		}

		public void setBlogid(int blogid) {
			this.blogid = blogid;
		}

		public int getUser_ID() {
			return User_ID;
		}

		public void setUser_ID(int user_ID) {
			User_ID = user_ID;
		}
		
		
		
	}


