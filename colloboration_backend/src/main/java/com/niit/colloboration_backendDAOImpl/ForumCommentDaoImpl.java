package com.niit.colloboration_backendDAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.colloboration_backendDAO.ForumCommentDAO;

public class ForumCommentDaoImpl implements ForumCommentDAO {
	
		
		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		public void ForumCommentDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}

	}
	