package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.h2.engine.Session;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.colloboration_backendDAO.EventDao;
import com.niit.colloboration_backendModel.EventParticipants;
import com.niit.colloboration_backendModel.Events;

public class EventDAOImpl implements EventDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public EventDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

@Transactional
	public Events addEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().save(event);
		return event;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return event;
		}
	}

@Transactional
	public boolean updateEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

@Transactional
	public boolean deleteEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().delete(event);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
@Transactional
public boolean deleteEventpars(EventParticipants eventparticipants) {
	try
	{
	sessionFactory.getCurrentSession().delete(eventparticipants);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}
@Transactional
	public Events getevent(int eventid) {
		Session session=(Session) sessionFactory.openSession();
		Events events = (Events) ((org.hibernate.Session) session).get(Events.class,eventid);
		session.close();
		return events;
	}

@Transactional
	public ArrayList<Events> getAllevents() {
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Events> eventlist=(ArrayList<Events>)((SharedSessionContract) session).createQuery("from Events where status='A'").list();
		session.close();
		return eventlist;
	}

@Transactional
	public boolean applyevent(EventParticipants eventparticipants) {
		try
		{
		sessionFactory.getCurrentSession().save(eventparticipants);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

@Transactional
	public ArrayList<EventParticipants> myevents(int myid) {
		System.err.println(myid);
		Session session = (Session) sessionFactory.openSession();
		ArrayList<EventParticipants> eventpars=(ArrayList<EventParticipants>)((SharedSessionContract) session).createQuery("from EventParticipants where userid="+myid).list();
		session.close();
		return eventpars;
	}

@Transactional
	public ArrayList<EventParticipants> checkIfeveAppliied(int eventid, int myid) {
		Session session = (Session) sessionFactory.openSession();
		ArrayList<EventParticipants> checkifappliedevent=(ArrayList<EventParticipants>)((SharedSessionContract) session).createQuery("from EventParticipants where userid="+myid+" and eventid="+eventid).list();
	session.close();
	return checkifappliedevent;
	}

@Transactional
	public ArrayList<EventParticipants> eventpars(int eventid) {
		Session session = (Session) sessionFactory.openSession();
		ArrayList<EventParticipants> eventpars=(ArrayList<EventParticipants>)((SharedSessionContract) session).createQuery("from EventParticipants where  eventid="+eventid).list();
		session.close();
		return eventpars;
	}
	
	@Transactional
	public ArrayList<Events> eventrequests()
	{
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Events> eventreq=(ArrayList<Events>) ((SharedSessionContract) session).createQuery("from Events where (status='P' or status='R')").list();
		session.close();
		return eventreq;
	}
	
	@Transactional
	public boolean approveevent(Events events)
	{
		
		
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(events);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
		
	}
	
	
	@Transactional
	public boolean rejectevent(Events events)
	{
		
		
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(events);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
		
	}
	
	
	}
	

