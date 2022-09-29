package com.cg.jss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jss.entity.Job;
@Service
public interface JobService {

	
	public Job searchByJobId(Integer job_id);
	
	public void deleteJobById(Integer job_id);
	
	
	public List<Job> searchJobBySkill(String skill);
	
	public List<Job> searchJobByTitle(String title);
	
	public List<Job> searchJobByLocation(String location);

	Job updateJob(Integer job_id, Job job);
	
	void addToBasket(Integer jobId);
	
	List<Job> viewFromBasket();
	
	void removeFromBasket(Integer jobId);
	
	List<Job> getAllJobs();
	
	
}
