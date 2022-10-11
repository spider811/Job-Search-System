package com.cg.jss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jss.entity.Job;
@Service
public interface JobService {

	Job searchByJobId(Integer job_id);

	void deleteJobById(Integer job_id);

	List<Job> searchJobBySkill(String skill);

	List<Job> searchJobByTitle(String title);

	List<Job> searchJobByLocation(String location);

	Job updateJob(Integer job_id, Job job);

	void addToBasket(Integer jobId);

	List<Job> viewFromBasket();

	void removeFromBasket(Integer jobId);

	List<Job> getAllJobs();

}
