package com.niit.colloboration_backendModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BlogComments {
	/**
	 * 
	 */
	
	@Id
    @GeneratedValue 
    @Column(name = "BlogcomId", nullable = false)
	private int blogcomid;
	
	@Column(name = "BlogComm", nullable = false)
    private String blogcomm;
	


	@Column(name = "Blogid", nullable = false)
	private int blogid;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "Username", nullable = false)
	private String username;
	
	
	
	

	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	
	public int getBlogcomid() {
		return blogcomid;
	}
	public String getBlogcomm() {
		return blogcomm;
	}
	public void setBlogcomm(String blogcomm) {
		this.blogcomm = blogcomm;
	}
	public void setBlogcomid(int blogcomid) {
		this.blogcomid = blogcomid;
	}


}
