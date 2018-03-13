package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.colloboration_backendModel.Blog;
import com.niit.colloboration_backendModel.BlogComment;
import com.niit.colloboration_backendModel.Forum;
import com.niit.colloboration_backendModel.ForumComments;
import com.niit.colloboration_backendModel.ForumRequests;
import com.niit.colloboration_backendModel.Friend;
import com.niit.colloboration_backendModel.Job;
import com.niit.colloboration_backendModel.JobApplications;
import com.niit.colloboration_backendModel.Notifications;
import com.niit.colloboration_backendModel.User;

@Configuration
@ComponentScan("com.niit")
public class DBConfig
{
	
	 @Autowired
	    @Bean
	    public SessionFactory sessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
	        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
	        
	        sessionBuilder.addProperties(getHibernateProperties());
	        
	        sessionBuilder.addAnnotatedClass(User.class);
	        sessionBuilder.addAnnotatedClass(Blog.class);
	        sessionBuilder.addAnnotatedClass(Job.class);
	        sessionBuilder.addAnnotatedClass(JobApplications.class);
	        sessionBuilder.addAnnotatedClass(BlogComment.class);
	        sessionBuilder.addAnnotatedClass(Forum.class);
	        sessionBuilder.addAnnotatedClass(ForumComments.class);
	        sessionBuilder.addAnnotatedClass(ForumRequests.class);
	        sessionBuilder.addAnnotatedClass(Friend.class);
	        sessionBuilder.addAnnotatedClass(Notifications.class);
	        
	        
	        
	        return sessionBuilder.buildSessionFactory();
	    }
	    @Autowired
	    @Bean(name = "datasource")
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/viewdb");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        return dataSource;
	    }

	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	  /*      properties.put("hibernate.connection.autocommit", true);*/
	        return properties;
	    }
	    @Bean
		@Autowired
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }
	
}
