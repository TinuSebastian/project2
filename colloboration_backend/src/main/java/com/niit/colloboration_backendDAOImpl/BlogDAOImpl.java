package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.colloboration_backendDAO.BlogDao;
import com.niit.colloboration_backendModel.Blog;
import com.niit.colloboration_backendModel.BlogComments;

@Repository("blogDAO")

	public class BlogDAOImpl implements BlogDao {
		
		@Autowired
		SessionFactory sessionFactory;
		
		
		@Autowired
		public BlogDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
	@Transactional
		public boolean addBlog(Blog blog) {
			try
			{
			sessionFactory.getCurrentSession().save(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
			
		}
	@Transactional
		public boolean updateBlog(Blog blog) {
			
			try
			{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
		}
	@Transactional
		public boolean deleteBlog(Blog blog) {
		
			try
			{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
		}
	@Transactional
		public Blog getBlog(int blogId) {
			Session session=(Session) sessionFactory.openSession();
			Blog blog = (Blog) ((org.hibernate.Session) session).get(Blog.class, blogId);
			session.close();
			return blog;
			
		}
	@Transactional
		public ArrayList<Blog> getAllBlogs() {
		
			Session session = (Session) sessionFactory.openSession();
			ArrayList<Blog> blogList=(ArrayList<Blog>)session.createQuery("from Blog where status='Y'").list();
			session.close();
			return blogList;
		}
	@Transactional
		public boolean approveBlog(Blog blog) {
			
			try{
				blog.setStatus("YES");
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
				return true;
				
			}
			catch(Exception e)
			{
			
			return false;
			}
		}
	@Transactional
		public boolean rejectBlog(Blog blog) {
			try{
				blog.setStatus("NO");
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
				return true;
				
			}
			catch(Exception e)
			{
			
			return false;
			}
			

	}


	@Transactional
	public boolean like(int blogid) {
		
		try
		{
			Session session=(Session) sessionFactory.openSession();
			Blog blog = (Blog) session.get(Blog.class,blogid);
			
			((org.hibernate.Session) session).update(blog);
			
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
		
		
	}
	@Transactional
	public boolean dislike(int blogid) {
		try
		{
			Session session=(Session) sessionFactory.openSession();
			Blog blog = (Blog) ( session).get(Blog.class, blogid);
			blog.setLikes(blog.getDislikes()+1);
			((org.hibernate.Session) session).update(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
		
	}

	@Transactional
		public boolean addBlogComment(BlogComments blogcomment) {
			try
			{
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}

			
		}
	@Transactional
	public BlogComments getBlogComment(int commentId)
	{
		Session session=(Session) sessionFactory.openSession();
		BlogComments blogcomment = (BlogComments) ((org.hibernate.Session) session).get(BlogComments.class, commentId);
		session.close();
		return blogcomment;
		
	}

	@Transactional
		public boolean deleteBlogComment(BlogComments blogcomment) {
			try
			{
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}

			
		}
	@Transactional
		public boolean updateBlogComment(BlogComments blogcomment) {
			try
			{
			sessionFactory.getCurrentSession().update(blogcomment);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}

			
		}


	@Transactional
	public ArrayList<BlogComments> getAllBlogComments(int blogid) {
		Session ssn=(Session) sessionFactory.openSession();
		
		
		org.hibernate.Query q= ((SharedSessionContract) ssn).createQuery("from BlogComments where blogid="+blogid);
		ArrayList<BlogComments> l=(ArrayList<BlogComments>) q.list();
		
	    
	    ssn.close();


		
		return l;
		
	}

	@Transactional
	public boolean incview(int blogid) {
		try
		{
			Session session=(Session) sessionFactory.openSession();
			Blog blog = (Blog) ((org.hibernate.Session) session).get(Blog.class, blogid);
			
			((org.hibernate.Session) session).update(blog);
			
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}


	@Transactional
	public ArrayList<Blog> getAllBlogRequests()
	{
		
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Blog> blogreq=(ArrayList<Blog>)((SharedSessionContract) session).createQuery("from Blog where status='A'").list();
		session.close();
		return blogreq;	
		
	}
	public ArrayList<Blog> getAllMyBlogs(String email) {
		
		
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Blog> myblogs=(ArrayList<Blog>)((SharedSessionContract) session).createQuery("from Blog where username='"+email+"'").list();
		session.close();
		return myblogs;	
		
	}



	}


