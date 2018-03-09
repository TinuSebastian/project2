package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.management.Query;
import javax.transaction.Transactional;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.colloboration_backendDAO.FriendDao;
import com.niit.colloboration_backendModel.Friend;
import com.niit.colloboration_backendModel.Users;

public class FriendDaoImpl implements FriendDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public void FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	//sending friend requests
@Transactional
	public boolean addFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

//accept friend requests
@Transactional
	public boolean accept(int friendreqid) {
		try
		{Session session=(Session) sessionFactory.openSession();
		Friend friend=(Friend) ((org.hibernate.Session) session).get(Friend.class,friendreqid);
		friend.setStatus("Y");
		((org.hibernate.Session) session).saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}


//rejecting friendrequests
@Transactional
	public boolean reject(int friendreqid) {
		try
		{Session session=(Session) sessionFactory.openSession();
		Friend friend=(Friend) ((org.hibernate.Session) session).get(Friend.class,friendreqid);
		friend.setStatus("N");
		((org.hibernate.Session) session).saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	}


//fetching all my friend requests
@Transactional
	public ArrayList<Friend> getAllFriendRequestsByUser( int userid) {
		

		Session session = (Session) sessionFactory.openSession();
		ArrayList<Friend> myfriends=(ArrayList<Friend>)((SharedSessionContract) session).createQuery("from Friend where FRI_ID="+userid+" and status='A'").list();
		session.close();
		return myfriends;
	}

//retyrieving everything from friend table 
@Transactional
	public ArrayList<Friend> getAllFriend() {
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Friend> Allfriends=(ArrayList<Friend>)((SharedSessionContract) session).createQuery("from Friend").list();
		session.close();
		return Allfriends;
		
	}

//fetching all my friends 
@Transactional
public ArrayList<Friend> getAllMyFriend(int myid) {
	Session session = (Session) sessionFactory.openSession();
	Query q= (Query) ((SharedSessionContract) session).createQuery("from Friend where status='YES' and (U_ID="+myid+" or FRI_ID="+myid+")" );
ArrayList<Friend> myfriends=(ArrayList<Friend>)((org.hibernate.Query) q).list();
return myfriends;
	}

@Transactional
public ArrayList<Friend> getAllMyFriendpend(int myid) {
	Session session = (Session) sessionFactory.openSession();
	Query q= (Query) ((SharedSessionContract) session).createQuery("from Friend where (U_ID="+myid+" or FRI_ID="+myid+")");
ArrayList<Friend> myfriends=(ArrayList<Friend>)((org.hibernate.Query) q).list();
return myfriends;
	}


//fetching all pending entries like we not acceped or he not accepted
@Transactional
public ArrayList<Friend> getAllpendingentries(int myid) {
	Session session = (Session) sessionFactory.openSession();
	Query q= (Query) ((SharedSessionContract) session).createQuery("from Friend where  status='A' and( U_ID="+myid+" or FRI_ID="+myid+") ");
ArrayList<Friend> myfriends=(ArrayList<Friend>)((org.hibernate.Query) q).list();
return myfriends;
	}


//
@Transactional
public ArrayList<Friend> getAllPendingrequests( int userid) {
	

	Session session = (Session) sessionFactory.openSession();
	ArrayList<Friend> myfriends=(ArrayList<Friend>)((SharedSessionContract) session).createQuery("from Friend where U_ID="+userid+" and status='A'").list();
	session.close();
	return myfriends;
}



@Transactional
public Users getUserById(int userid) {
	Users user=new Users();
	try{
		Session session= (Session) sessionFactory.openSession();
		Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where userid="+userid);
		 user=(Users)((org.hibernate.Query) query).list().get(0);
		session.close();
		
	}
	catch(Exception e)
	{
		
		
	}
	return user;
}

@Transactional
public boolean delete(Friend friend) {
	try
	{
		
	sessionFactory.getCurrentSession().delete(friend);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}

@Transactional
public Friend getfriendrequest(int friendreqid,int myid) {
	
	Session session = (Session) sessionFactory.openSession();
	Query q= (Query) ((SharedSessionContract) session).createQuery("from Friend where (U_ID="+myid+" and FRI_ID="+friendreqid+") or (U_ID="+friendreqid+" and FRI_ID="+myid+")" );
Friend mynfriend=(Friend)((org.hibernate.Query) q).list().get(0);
return mynfriend;
	
}


@Transactional
public Friend acceptfriendrequest(Friend friend)
{
	try
	{
	sessionFactory.getCurrentSession().update(friend);
	return null;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}
}




}

