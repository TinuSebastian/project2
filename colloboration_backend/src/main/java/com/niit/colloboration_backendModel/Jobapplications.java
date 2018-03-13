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
	@Table(name="JobApplication")
	public class JobApplications implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
	    @GeneratedValue 
	    @Column(name="JobapplyId")
		private int jobapplyid;
		
		@Column(name="Jobid")
		private int jobid;

		@Column(name="UserId")
		private int user_id;

		public int getJobapplyid() {
			return jobapplyid;
		}

		public void setJobapplyid(int jobapplyid) {
			this.jobapplyid = jobapplyid;
		}

		public int getJobid() {
			return jobid;
		}

		public void setJobid(int jobid) {
			this.jobid = jobid;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
		
		
		
	}



