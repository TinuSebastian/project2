package com.niit.colloboration_backendModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class EventParticipants implements Serializable {
		

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;






		@Id
	    @GeneratedValue 
	    @Column(name="Participantid")
		private int participantid;
		
		@Column(name="EventId")
		private int eventid;
		
		


		@Column(name="UserId")
		private int userid;
		public int getParticipantid() {
			return participantid;
		}




		public void setParticipantid(int participantid) {
			this.participantid = participantid;
		}




		public int getEventid() {
			return eventid;
		}




		public void setEventid(int eventid) {
			this.eventid = eventid;
		}




		public int getUserid() {
			return userid;
		}




		public void setUserid(int userid) {
			this.userid = userid;
		}



	}


