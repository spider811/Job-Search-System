package com.cg.jss.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jss.entity.AppliedJob;
import com.cg.jss.entity.Employer;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.entity.Skillset;
import com.cg.jss.exception.EmployerNotFoundException;
import com.cg.jss.exception.JobNotFoundException;
import com.cg.jss.exception.JobSeekerNotFoundException;
import com.cg.jss.repository.AppliedJobsRepository;
import com.cg.jss.repository.EmployerRepository;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.repository.JobSeekerRepository;
import com.cg.jss.repository.SkillSetRepository;
import com.cg.jss.service.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	SkillSetRepository skillSetRepository;
	
	@Autowired
	AppliedJobsRepository appliedJobsRepository;

	@Override
	public Employer registerEmployer(Employer employer) {
		Employer registerEmployer=employerRepository.save(employer);
		return registerEmployer;
	}

	@Override
	public Job postAjob(Job job, Integer id) throws EmployerNotFoundException {
		Employer employer=employerRepository.findById(id).orElseThrow(()-> new EmployerNotFoundException("Employeer Not Found"));
		job.setEmployer(employer);
		Job postJob=jobRepository.save(job);
		return postJob;
	}

	@Override
	public List<Job> getAllJobs() throws EmployerNotFoundException {
		return jobRepository.findAll();
	}

	@Override
	public Job getJobById(Integer job_id) throws EmployerNotFoundException {
		Optional<Job> jobOpt=jobRepository.findById(job_id);
		if(jobOpt.isPresent()) {
			return jobOpt.get();
		}
		else {
			throw new EmployerNotFoundException("Not found");
		}
	}

	@Override
	public void deleteJobById(Integer job_id) throws JobNotFoundException {
		Job job=jobRepository.findById(job_id).orElseThrow(()->new JobNotFoundException("Job with "+job_id+"Not found"));
		jobRepository.deleteById(job_id);
	}


	@Override
	public List<JobSeeker> searchJobSeekerBySkills(String skills) throws EmployerNotFoundException {
		List<Skillset> skillsets = skillSetRepository.findBySkill(skills);
		List<JobSeeker> skilledJobSeekers = new ArrayList<>();
		for(int i=0;i<skillsets.size();i++)
		{
			JobSeeker jobSeeker = jobSeekerRepository.findById(skillsets.get(i).getJobSeeker().getJobseeker_Id()).orElseThrow(()->new JobSeekerNotFoundException("Job Seeker Not Found"));
			if(!skilledJobSeekers.contains(jobSeeker))
			{
				skilledJobSeekers.add(jobSeeker);
			}
		}
		return skilledJobSeekers;
	}

	@Override
	public List<JobSeeker> searchJobSeekerByJobId(Integer jobId) {
		Job job=jobRepository.findById(jobId).orElseThrow(()->new JobNotFoundException("Job with "+jobId+"Not found"));
		List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();
		List<AppliedJob> appliedJobs = appliedJobsRepository.findByJob(job);
		for(int i =0;i<appliedJobs.size();i++)
		{
			JobSeeker jobSeeker = appliedJobs.get(i).getJobseeker();
			if(!jobSeekers.contains(jobSeeker))
			{
				jobSeekers.add(jobSeeker);
			}
		}
		return jobSeekers;
	}
	@Override
	public List<Employer> getEmployerByOrganization(String organizationName){
		return employerRepository.findByOrganizationName(organizationName);
	}

	@Override
	public List<Employer> getAllEmployers() {
		return employerRepository.findAll();
	}

}
