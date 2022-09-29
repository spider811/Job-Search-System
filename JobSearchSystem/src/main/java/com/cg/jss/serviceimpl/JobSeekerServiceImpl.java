package com.cg.jss.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.jss.entity.AppliedJobs;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.entity.Skillset;
import com.cg.jss.exception.JobNotFoundException;
import com.cg.jss.exception.JobSeekerNotFoundException;
import com.cg.jss.repository.AppliedJobsRepository;
import com.cg.jss.repository.EmployerRepository;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.repository.JobSeekerRepository;
import com.cg.jss.repository.SkillSetRepository;
import com.cg.jss.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private AppliedJobsRepository appliedJobsRepository;
	
	@Autowired
	private SkillSetRepository skillSetRepository;
	
	@Override
	public JobSeeker registerJobSeeker(JobSeeker jobSeeker) throws JobSeekerNotFoundException {
		JobSeeker registerSeeker=jobSeekerRepository.save(jobSeeker);
		List<Skillset> skillsets = registerSeeker.getSkillSet();
		for(Skillset skill:skillsets)
		{
			skill.setJobSeeker(jobSeeker);
			skillSetRepository.save(skill);
		}
		return registerSeeker;
	}

	@Override
	public Job getJobById(Integer jobId) throws JobSeekerNotFoundException {
		Optional<Job> optJob=jobRepository.findById(jobId);
		if(optJob.isPresent()) {
			return optJob.get();
		}
		else {
			throw new JobSeekerNotFoundException("Jobseeker with id:"+jobId+" nor found");
		}
	}

	@Override
	public void applyAJob(Integer jobId,Integer jobSeekerId) throws JobSeekerNotFoundException {
		Job job = jobRepository.findById(jobId).orElseThrow(()-> new JobNotFoundException("Job with "+jobId+" not found"));
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId).orElseThrow(()-> new JobSeekerNotFoundException("Job Seeker with "+jobSeekerId+" not found"));
		List<AppliedJobs> appliedJobsList = job.getAppliedJob();
		AppliedJobs appliedJobs = new AppliedJobs();
		appliedJobs.setJobseeker(jobSeeker);
		appliedJobs.setJob(job);
		appliedJobsList.add(appliedJobs);
		job.setAppliedJob(appliedJobsList);
		jobRepository.save(job);
	}

	@Override
	public Integer deleteAppliedJob(Integer appliedJobId) throws JobSeekerNotFoundException {
		AppliedJobs appliedJobs=appliedJobsRepository.findById(appliedJobId).orElseThrow(()->new JobSeekerNotFoundException("Did not apply for this job"));
		appliedJobsRepository.deleteById(appliedJobId);
		return appliedJobId;
	}

	@Override
	public List<Job> getAllAppliedJobs(Integer jobSeekerId) throws JobSeekerNotFoundException {
		JobSeeker jobSeeker =jobSeekerRepository.findById(jobSeekerId).orElseThrow(()->new JobSeekerNotFoundException("JobSeeker with "+jobSeekerId+" not found "));
		List<AppliedJobs> appliedJobs=appliedJobsRepository.findByJobseeker(jobSeeker);
		List<Job> jobs = new ArrayList<>();
		for(int i=0;i<appliedJobs.size();i++)
		{
			if(!jobs.contains(appliedJobs.get(i).getJob()))
					{
						jobs.add(appliedJobs.get(i).getJob());
					}
		}
		return jobs;
	}
	
	
	@Override
	public JobSeeker update(JobSeeker jobSeeker, Integer jobSeekerId) {
		JobSeeker jobSeekerInfo= jobSeekerRepository.findById(jobSeekerId).orElseThrow(()->new JobSeekerNotFoundException("JobSeeker with "+jobSeekerId+" not found "));
		jobSeekerInfo.setUsername(jobSeeker.getUsername());
		jobSeekerInfo.setPassword(jobSeeker.getPassword());
		jobSeekerInfo.setSkillSet(jobSeeker.getSkillSet());
		jobSeekerInfo.setEmail(jobSeeker.getEmail());
		jobSeekerInfo.setLocationPreference(jobSeeker.getLocationPreference());
		jobSeekerInfo.setJobseekerName(jobSeeker.getJobseekerName());
		jobSeekerInfo.setContactNumber(jobSeeker.getContactNumber());
		jobSeekerInfo.setAddress(jobSeeker.getAddress());
		jobSeekerRepository.save(jobSeekerInfo);
		return jobSeekerInfo;
	}

	

	
}
