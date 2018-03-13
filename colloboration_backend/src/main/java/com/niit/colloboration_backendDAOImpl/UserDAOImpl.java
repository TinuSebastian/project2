package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloboration_backendDAO.UserDAO;
import com.niit.colloboration_backendModel.Friend;
import com.niit.colloboration_backendModel.User;

@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO
{
	
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	 @Transactional
		public ArrayList<User> getAllUser() {
			
			String hql = "from User";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);		
			return (ArrayList<User>) query.list();
			
		}
	  @Transactional
	  public boolean saveUser(User user) {
	  	
	  	try {
	  		sessionFactory.getCurrentSession().save(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
	  }
	  
	  @Transactional	  
	public boolean updateOnlineStatus(User user) {
		try{
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
		
	}
	  
	@Transactional 
	public User getUser(int userid) {
		
		System.err.println(userid);
		User user=new User();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from User where user_id="+userid);
			 user=(User)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}
	
	
	@Transactional 
	public User getUserbyId(int userid) {
		
		
		User user=new User();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from User where user_id="+userid);
			 user=(User)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}

	public boolean checkLogin(User user) {
		try{
			Session session=sessionFactory.openSession();
			System.out.println(user.getEmail_id());
			System.out.println(user.getPassword());
			Query query=session.createQuery("from User where email_id='"+user.getEmail_id()+"' and password='"+user.getPassword()+"'");
			
			User user1=(User)query.list().get(0);
			
			if(user1==null)
			{
				
				return false;
			}
			else
			{
				System.out.println("2.."+user1.getEmail_id());
				System.out.println("2..."+user1.getPassword());
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}
	}
	public User getUserbyemail_id(String email_id) {
		User user=new User();
		System.out.println(email_id);
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from User where email_id='"+email_id+"'");
			 user=(User)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return user;
		
	}
	public ArrayList<Friend> checkismyfriend(int userid, int myid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public ArrayList<User> userrequests() {
		Session session = sessionFactory.openSession();
		ArrayList<User> userreq=(ArrayList<User>) session.createQuery("from User where status='P'").list();
		session.close();
		return userreq;
	}
	@Transactional
	public boolean approveusers(User users) {
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(users);
	  		return true;
	  	} catch (HibernateException e) 
		{
	  		e.printStackTrace();
	  		return false;
	  	}
	}
	@Transactional
	public boolean checkLoginsimp(User user) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from User where email_id='"+user.getEmail_id()+"' and password='"+user.getPassword()+"'");
		
		ArrayList<User> user1=(ArrayList<User>)query.list();
		if(user1.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Transactional
	public boolean checkLoginsemail(User user) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from User where email_id='"+user.getEmail_id()+"'");
		ArrayList<User> us=(ArrayList<User>)query.list();
		if(us.isEmpty())
			{
			return false;
			}
		else
		{
			return true;
		}
	}
	@Transactional
	public boolean rejectusers(User users) {
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(users);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
		
	}
	
	@Transactional
	public List<User> requestFriend(int user) {
     Query query = sessionFactory.getCurrentSession().createQuery("from User where user_id not in(select friendid From Friend where user_id='"+user+"') ");
		System.err.println("UserLIst : "+(List<User>)query.list());
		return (List<User>)query.list();
	}
	



}
