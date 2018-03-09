package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.colloboration_backendDAO.JobDao;
import com.niit.colloboration_backendModel.Jobapplications;
import com.niit.colloboration_backendModel.Job;

public class JobDaoImpl implements JobDao 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public JobDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addjob(Job job) {
		
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	@Transactional
	public boolean updatejob(Job job) {

		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	@Transactional
	public boolean deletejob(Job job) {
		

		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	
	@Transactional
	public boolean deletejobApp(Jobapplications jobapplication) {
		

		try
		{
		sessionFactory.getCurrentSession().delete(jobapplication);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	
	
	@Transactional
	public Job getjob(int jobId) {
		
		Session session=sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobId);
		session.close();
		return job;
		
	}

	@Transactional
	public ArrayList<Job> getAlljobs() {
		
		Session session = sessionFactory.openSession();
		ArrayList<Job> jobList=(ArrayList<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;
		
	}


	@Transactional
	public boolean applyJob(Jobapplications jobapplications){
		try
		{
		sessionFactory.getCurrentSession().save(jobapplications);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
		
	}
	@Transactional
	public ArrayList<Jobapplications> myjobs(int myid) {
		System.err.println(myid);
		Session session = sessionFactory.openSession();
		ArrayList<Jobapplications> jobapllicationlist=(ArrayList<Jobapplications>)session.createQuery("from JobApplications where userid="+myid).list();
		session.close();
		return jobapllicationlist;
	}
	
	@Transactional
	public ArrayList<Jobapplications> checkIfApplied(int jobid, int myid) {
		Session session = sessionFactory.openSession();
		ArrayList<Jobapplications> checkifapplied=(ArrayList<Jobapplications>)session.createQuery("from JobApplications where userid="+myid+" and jobid="+jobid).list();
	session.close();
	return checkifapplied;
	}

	public ArrayList<Jobapplications> jobapps(int jobid) {
	
		
	Session session = sessionFactory.openSession();
	ArrayList<Jobapplications> jobapps=(ArrayList<Jobapplications>)session.createQuery("from JobApplications where  jobid="+jobid).list();
	session.close();
	return jobapps;
	
	
	}
	

}
	

	
				