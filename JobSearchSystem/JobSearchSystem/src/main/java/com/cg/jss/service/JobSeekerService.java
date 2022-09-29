package com.cg.jss.service;

import java.util.List;

import com.cg.jss.entity.AppliedJob;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.exception.JobSeekerNotFoundException;

public interface JobSeekerService {
	
	public JobSeeker registerJobSeeker(JobSeeker jobSeeker) throws JobSeekerNotFoundException;
	
	public Job getJobById(Integer jobId) throws JobSeekerNotFoundException;
	
	public Integer deleteAppliedJob(Integer appliedJobId) throws JobSeekerNotFoundException;
	
	public List<Job> getAllAppliedJobs(Integer jobSeekerId) throws JobSeekerNotFoundException;

	void applyAJob(Integer jobId, Integer jobSeekerId) throws JobSeekerNotFoundException;
	
	public JobSeeker update(JobSeeker jobSeeker, Integer jobSeekerId);
}
