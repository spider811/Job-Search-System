package com.cg.jss.service;

import java.util.List;

import com.cg.jss.entity.Employer;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.exception.EmployerNotFoundException;

public interface EmployerService {
	public Employer registerEmployer(Employer employer);

	public Job postAjob(Job job,Integer id) throws EmployerNotFoundException;
	
	public List<Job> getAllJobs() throws EmployerNotFoundException;
	
	public Job getJobById(Integer job_id) throws EmployerNotFoundException;
	
	public void deleteJobById(Integer job_id) throws EmployerNotFoundException;
	
	public List<JobSeeker> searchJobSeekerByJobId(Integer jobId);
	
	public List<JobSeeker> searchJobSeekerBySkills(String skills) throws EmployerNotFoundException;

	List<Employer> getEmployerByOrganization(String organizationName);

	List<Employer> getAllEmployers();

}
