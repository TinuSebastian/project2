/*package com.niit.colloboration_backend;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.colloboration_backendDAO.UserDAO;
import com.niit.colloboration_backendModel.User;

public class UserDAOTest {
	@Autowired
	public static UserDAO userDAO;
		
		
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			userDAO=(UserDAO)context.getBean("userDAO");
		}
		
	@Ignore
		@Test
		public void getAllUsersTest()
		{
			ArrayList<User> user= userDAO.getAllUser();
			for(User u:user)
			{
				System.out.println(u.getFirst_name());
				System.out.println(u.getLast_name());
				System.out.println(u.getPassword());
			
			
		}
		}
        @Ignore
			@Test
			public void addUserTest()
			{
				User user =new User();
				user.setFirst_name("amal ");
				user.setLast_name("saleem");
				user.setUsername("Amaal");
				user.setEmail_id("amal@gmail.com");
				user.setIsonline("N");
				user.setGender("F");
				user.setPassword("amal1811");
				user.setRole("ROLE_USER");
				user.setUser_id(1236);
				user.setContact("12345687");
				
				
			
				assertTrue("Problem in Inserting USer",userDAO.saveUser(user));
				
				
				
				
			}
			
			@Ignore
			@Test
			public void getUserTest()
			{
				
				User user=(User)userDAO.getUser(1);
				System.out.println(user.getEmail_id());
				
			}
			
			@Ignore
			@Test
			public void updateOnlineStatusTest()

			{
				User user=userDAO.getUser(2);
				
				assertTrue("Problem in updating Online Status",userDAO.updateOnlineStatus(user));
				
				
			}
			@Ignore
			@Test
			public void checklogin()
			{
				User user=(User)userDAO.getUser(33);
				System.out.println(user.getEmail_id());
				
				assertTrue("Problem in login Status",userDAO.checkLogin(user));
				
			}
			@Ignore
			@Test
			public void getuserbyemail()
			{
				User user=(User)userDAO.getUserbyId(1);
				System.out.println(user.getEmail_id());
				
				
				
			}


}


*/