package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.notification;

public interface notificationDao {
	
		public boolean addNotifications(notification notification) ;
		public ArrayList<notification> getAllNotifications( String userName) ;
		public boolean deleteNotifications(notification notification);
		public notification getNotifications(int notifid);
	}
