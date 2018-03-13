package com.niit.colloboration_middleware.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.colloboration_backendDAO.NotificationsDAO;
import com.niit.colloboration_backendModel.Notifications;
import com.niit.colloboration_backendModel.User;

@RestController
	@RequestMapping("/notifications")
	public class NotificationController {
		@Autowired 
		NotificationsDAO notificationsDAO;
		
		
		
		@RequestMapping(value="/getAllNotis",method=RequestMethod.GET,headers = "Accept=application/json")
		public ResponseEntity<ArrayList<Notifications>> getAllNotis(HttpSession session){
			User user=(User)session.getAttribute("currentuser");
			System.out.println("in getall notis");
			System.out.println(user.getEmail_id());
			ArrayList<Notifications> notis=(ArrayList<Notifications>)notificationsDAO.getAllNotifications(user.getEmail_id());
			for(Notifications n:notis)
			{
				System.err.println(n.getName());
			}
					return new ResponseEntity<ArrayList<Notifications>>(notis,HttpStatus.OK);
					
		
		
		
		}
		
		
		@RequestMapping(value="/deleteNoti/{notifid}",method=RequestMethod.GET)
		public ResponseEntity<ArrayList<Notifications>> deleteNoti(@PathVariable("notifid") int notifid,HttpSession session){
		
		User us=(User)session.getAttribute("currentuser");
			
			Notifications noti=notificationsDAO.getNotifications(notifid);
		if(notificationsDAO.deleteNotifications(noti))
		{
			ArrayList<Notifications> bc=notificationsDAO.getAllNotifications(us.getEmail_id());
		
			return new ResponseEntity<ArrayList<Notifications>>(bc,HttpStatus.OK);	
			
				
			
			
		}
		else
		{
			return null;
		}
		
		
		
		
		}}


