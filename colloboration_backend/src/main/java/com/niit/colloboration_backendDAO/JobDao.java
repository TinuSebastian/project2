package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.Job;
import com.niit.colloboration_backendModel.Jobapplications;

public interface JobDao
{public boolean addjob(Job job);
public boolean updatejob(Job job);
public  boolean deletejob(Job job) ;
public Job getjob(int jobId);
public ArrayList<Job> getAlljobs();
public boolean applyJob(Jobapplications jobapplications);
public ArrayList<Jobapplications> myjobs(int myid);
public ArrayList<Jobapplications> checkIfApplied(int jobid,int myid);
public ArrayList<Jobapplications> jobapps(int jobid);
public boolean deletejobApp(Jobapplications jobapplication);
}

