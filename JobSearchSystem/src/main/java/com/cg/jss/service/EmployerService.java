package com.cg.jss.service;

import java.util.List;

import com.cg.jss.entity.Employer;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.exception.EmployerNotFoundException;

public interface EmployerService {
	Employer registerEmployer(Employer employer);

	Job postAjob(Job job, Integer id) throws EmployerNotFoundException;

	List<Job> getAllJobs() throws EmployerNotFoundException;

	Job getJobById(Integer job_id) throws EmployerNotFoundException;

	void deleteJobById(Integer job_id) throws EmployerNotFoundException;

	List<JobSeeker> searchJobSeekerByJobId(Integer jobId);

	List<JobSeeker> searchJobSeekerBySkills(String skills) throws EmployerNotFoundException;

	List<Employer> getEmployerByOrganization(String organizationName);

	List<Employer> getAllEmployers();
	
	List<JobSeeker> getAllJobSeekers();
	
	public Employer update(Integer id, Employer employer);
	
	Employer getEmployerById(Integer employerId);
	

}
