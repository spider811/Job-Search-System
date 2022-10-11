package com.cg.jss.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jss.entity.Job;
import com.cg.jss.exception.JobNotFoundException;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.service.JobService;
@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepository jobRepository;


	@Override
	public Job searchByJobId(Integer job_id) {
		Job job = jobRepository.findById(job_id).orElseThrow(()->new JobNotFoundException("Job Not Found"));
		return job;
	}

	@Override
	public void deleteJobById(Integer job_id) {
		jobRepository.deleteById(job_id);
		
	}

	@Override
	public Job updateJob(Integer job_id,Job job) throws JobNotFoundException{
		Job oldjob = jobRepository.findById(job_id).orElseThrow(()->new JobNotFoundException("Job Not Found"));
		oldjob.setContactNo(job.getContactNo());
		oldjob.setDescription(job.getDescription());
		oldjob.setEmail(job.getEmail());
		oldjob.setStatus(job.getStatus());
		oldjob.setExperience(job.getExperience());
		oldjob.setLocation(job.getLocation());
		oldjob.setNoticePeriod(job.getNoticePeriod());
		oldjob.setSalary(job.getSalary());
		oldjob.setCompany(job.getCompany());
		oldjob.setTitle(job.getTitle());
		oldjob.setSkillSet(job.getSkillSet());
		jobRepository.save(oldjob);
		return oldjob;
	}

	@Override
	public List<Job> searchJobBySkill(String skill) {
		return jobRepository.findBySkillSet(skill);
	}


	@Override
	public List<Job> searchJobByLocation(String location) {
		return jobRepository.findByLocation(location);
	}

	@Override
	public void addToBasket(Integer jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(()->new JobNotFoundException("Job Not Found"));
		job.setFavourite(Boolean.TRUE);
		jobRepository.save(job);
	}

	@Override
	public List<Job> viewFromBasket() {
		return jobRepository.findByFavourite(Boolean.TRUE);
	}

	@Override
	public void removeFromBasket(Integer jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(()->new JobNotFoundException("Job Not Found"));
		job.setFavourite(Boolean.FALSE);
		jobRepository.save(job);
		
	}

	@Override
	public List<Job> searchJobByTitle(String title) {
		return jobRepository.findByTitle(title);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

}
