package com.niit.colloboration_backendModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FORUM")
public class Forum  implements Serializable
{
private static final long serialVersionUID = 1L;


	

	@Id
    @GeneratedValue 
    @Column(name = "ForumID", nullable = false)
	private int forumid;
	
	@Column(name = "Forumname", nullable = false)
    private String forumname;
	@Column(name = "ForumContent", nullable = false)
    private String forumcontent;
	
	
	
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumcontent() {
		return forumcontent;
	}
	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Forum() {
		super();
	}

}
