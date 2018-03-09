package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.Notifications;

public interface NotificationsDao
{
	public boolean addNotifications(Notifications notification) ;
	public ArrayList<Notifications> getAllNotifications( String username) ;
	public boolean deleteNotifications(Notifications notification);
	public Notifications getNotifications(int notifid);
}

