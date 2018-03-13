package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.Job;
import com.niit.colloboration_backendModel.JobApplications;

public interface JobDAO {
	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(Job job);
	public Job getjob(int jobId);
	public ArrayList<Job> getAlljobs();
	public boolean applyJob(JobApplications jobapplications);
	public ArrayList<JobApplications> myjobs(int myid);
	public ArrayList<JobApplications> checkIfApplied(int jobid,int myid);
	public ArrayList<JobApplications> jobapps(int jobid);
}

