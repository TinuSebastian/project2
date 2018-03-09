package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.colloboration_backendDAO.NotificationsDao;
import com.niit.colloboration_backendModel.Notifications;

public class NotificationsDaoImpl implements NotificationsDao{
	

	@Repository("NotificationsDAO")
	public class NotificationsDAOImpl implements NotificationsDao {
		
		@Autowired
		SessionFactory sessionFactory;
		
		@Autowired
		public NotificationsDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		
		@Transactional
		public boolean addNotifications(Notifications notification) {
			
			try
			{
			sessionFactory.getCurrentSession().save(notification);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
			
		}
		
		@Transactional
		public ArrayList<Notifications> getAllNotifications(String username) {
		
			Session session = (Session) sessionFactory.openSession();
			ArrayList<Notifications> notis=(ArrayList<Notifications>)((SharedSessionContract) session).createQuery("from Notifications where username='"+username+"'").list();
			session.close();
			return notis;
		}
		
		@Transactional
		public boolean deleteNotifications(Notifications notification) {
			
			try
			{
			sessionFactory.getCurrentSession().delete(notification);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
			
		}
		
		
		@Transactional
		public Notifications getNotifications(int notifid) {
			Session session=(Session) sessionFactory.openSession();
			Notifications noti = (Notifications) ((org.hibernate.Session) session).get(Notifications.class,notifid);
			session.close();
			return noti;
			
		}
		
	}

	public boolean addNotifications(Notifications notification) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Notifications> getAllNotifications(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteNotifications(Notifications notification) {
		// TODO Auto-generated method stub
		return false;
	}

	public Notifications getNotifications(int notifid) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
	