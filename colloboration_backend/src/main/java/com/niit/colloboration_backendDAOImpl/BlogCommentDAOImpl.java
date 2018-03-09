package com.niit.colloboration_backendDAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.colloboration_backendDAO.BlogCommentDao;

public class BlogCommentDAOImpl implements BlogCommentDao{
		
		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		public BlogCommentDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}

	}



