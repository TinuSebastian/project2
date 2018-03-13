package com.niit.colloboration_backendModel;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
@Table(name="Blog")
public class Blog 
{

	@Id
    @GeneratedValue 
    @Column(name = "BlogID", nullable = false)
	private int blogid;
	 @Column(name = "USER_ID", nullable = false)
		private int user_id;
	@Column(name = "Blogname", nullable = false)
    private String blogname;
	@Column(name = "BlogContent", nullable = false)
    private String blogcontent;

	

	@Column(name = "Staus", nullable = false)
    private String status;
	@Column(name = "Likes", nullable = false)
    private int likes;
	@Column(name = "Dislikes", nullable = false)
    private int dislikes;
	
	
	@Column(name = "Views", nullable = false)
    private int views;
	
	
	@Column(name = "Username", nullable = false)
    private String username;


	public int getBlogid() {
		return blogid;
	}


	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}


	public String getBlogname() {
		return blogname;
	}


	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}


	public String getBlogcontent() {
		return blogcontent;
	}


	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getDislikes() {
		return dislikes;
	}


	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public Blog(int blogid, int user_id, String blogname, String blogcontent, String status, int likes, int dislikes,
			int views, String username) {
		super();
		this.blogid = blogid;
		this.user_id = user_id;
		this.blogname = blogname;
		this.blogcontent = blogcontent;
		this.status = status;
		this.likes = likes;
		this.dislikes = dislikes;
		this.views = views;
		this.username = username;
	}


	public Blog() {
		super();
	}
	
	
	
	
	
	
	
}