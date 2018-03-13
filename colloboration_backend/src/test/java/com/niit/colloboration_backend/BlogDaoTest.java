/*package com.niit.colloboration_backend;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.colloboration_backendDAO.BlogDAO;
import com.niit.colloboration_backendDAO.UserDAO;
import com.niit.colloboration_backendModel.Blog;
import com.niit.colloboration_backendModel.BlogComment;
import com.niit.colloboration_backendModel.User;

public class BlogDAOTest
	{
		@Autowired
		private static BlogDAO blogDAO;
			@Autowired
		private static UserDAO userDAO;	
			
			
			
			@BeforeClass
			public static void initialize()
			{
				AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				blogDAO=(BlogDAO)context.getBean("blogDAO");
				userDAO=(UserDAO)context.getBean("userDAO");
			
			}

			
			
			
			
			
		@Ignore
			@Test
			public void addBlogTest()
			{
				Blog blog=new Blog();
				
				blog.setBlogcontent("vbcvshvcb");
				blog.setBlogname("hibernate spring");
				blog.setDislikes(4);
				blog.setLikes(10);
				blog.setStatus("approved");
				blog.setUsername("Amaal");
				blog.setViews(14);
				User user=(User)userDAO.getUser(1);
				
				System.out.println(user.getEmail_id());
				assertTrue("Problem in inserting   Blog",blogDAO.addBlog(blog));
				
				
				
			
			}
			
			
			
			
			@Ignore
			@Test
			public void getblogTest()
			{
				
				Blog blog=blogDAO.getBlog(41);
				System.out.println(blog.getBlogcontent());
				System.out.println(blog.getBlogname());
			}
			
			
			
			
		@Ignore
			@Test
			public void updateBlogTest()
			{
				
				Blog blog=(Blog)blogDAO.getBlog(3);
				blog.setBlogcontent("it is hibernate based");
				blog.setBlogname("hibernate core");
				assertTrue("Problem in Updating  Blog",blogDAO.updateBlog(blog));
				
				
			}
			
			
			
			
			@Ignore
			@Test
			public void deleteBlogTest()
			{
				Blog blog=(Blog)blogDAO.getBlog(33);
				assertTrue("Problem in Updating  Blog",blogDAO.deleteBlog(blog));
				
				
				
			}
			
			
			
			
			@Ignore
			@Test
			public void getAllBlogTest()
			{
				
			
				ArrayList<Blog> blog=(ArrayList<Blog>)blogDAO.getAllBlogs();
			for(Blog b:blog)
			{
				System.out.println(b.getBlogname());
			}
			
			}
			
			
			
			
		   @Ignore
			@Test
			public void approveBlogTest()
			{
				Blog blog=(Blog)blogDAO.getBlog(3);
				blog.setStatus("Y");
				assertTrue("Problem in Approving  Blog",blogDAO.approveBlog(blog));
				
			}
			
			
			
			
			@Ignore
			@Test
			public void rejectBlogTest()
			{
				Blog blog=(Blog)blogDAO.getBlog(3);
				blog.setStatus("N");
				assertTrue("Problem in Rejecting  Blog",blogDAO.rejectBlog(blog));
				
			}
			
			
			
			
			@Ignore
			@Test
			public void likeBlogTest()
			{
			
				Blog blog =blogDAO.getBlog(3);
				blog.setLikes(blog.getLikes()+1);
						assertTrue("problemin liking blog",blogDAO.updateBlog(blog));
				
			}
			
			
			
			
			@Ignore
			@Test
			public void dislikeBlogTest()
			{
			
				Blog blog =blogDAO.getBlog(3);
				blog.setDislikes(blog.getDislikes()+1);
				assertTrue("problemin disliking blog",blogDAO.updateBlog(blog));
				
				
			}
			
			
			
			
			
		@Ignore
			@Test
			public void addBlogComment()
			{
				BlogComment blogcomment = new BlogComment();
				
				blogcomment.setBlogid(4);
				blogcomment.setBlogcomm("v good");
				blogcomment.setBlogcomid(1000);
			
				assertTrue("Problem in Inserting BlogComment",blogDAO.addBlogComment(blogcomment));
			
			}
			
			
			
			
		@Ignore
			@Test
			public void getBlogCommentTest()
			{
				BlogComment blogcomment=(BlogComment)blogDAO.getBlogComment(1);
				System.out.println(blogcomment.getBlogcomm());
				
			}
			
			
			

		@Ignore
			@Test
			public void updateBlogCommentTest()
			{
				BlogComment blogcomment =blogDAO.getBlogComment(1);
				blogcomment.setBlogcomm("amazing");
				assertTrue("Problem in Updating  Blog",blogDAO.updateBlogComment(blogcomment));		
				
			}
			
			@Ignore
			@Test
			public void deleteBlogCommentTest()
			{
				BlogComment blogcomment=(BlogComment)blogDAO.getBlogComment(1);
				assertTrue("Problem in deleting  Blog",blogDAO.deleteBlogComment(blogcomment));
				
				

			}
			


	}


*/