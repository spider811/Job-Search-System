package com.cg.jss.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.jss.entity.AppliedJob;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.entity.Skillset;
import com.cg.jss.repository.AppliedJobsRepository;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.repository.JobSeekerRepository;
import com.cg.jss.repository.SkillSetRepository;
import com.cg.jss.serviceimpl.JobSeekerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class JobSeekerServiceTest {

	@Mock
	JobSeekerRepository jobSeekerRepository;
	
	@Mock
	JobRepository jobRepository;
	
	@Mock
	AppliedJobsRepository appliedJobsRepository;
	
	@Mock
	SkillSetRepository skillSetRepository;
	
	@InjectMocks
	JobSeekerServiceImpl jobSeekerService;
	
	@Test
	public void testRegisterJobSeeker()
	{
		JobSeeker jobSeekers = createMockJobSeeker().get(0);
		when(jobSeekerRepository.save(jobSeekers)).thenReturn(jobSeekers);
		JobSeeker jobSeeker = jobSeekerService.registerJobSeeker(jobSeekers);
		assert(jobSeekers==jobSeeker);
		
	}
	@Test
	void testGetJobById()
	{
		Optional<Job> job = Optional.of(createJobMockData().get(0));
		when(jobRepository.findById(1)).thenReturn(job);
		Job job2 = jobSeekerService.getJobById(1);
		assert(job.get()==job2);
	}
	@Test
	public void testUpdateJobSeeker()
	{
		Optional<JobSeeker> jobSeekers = Optional.of(createMockJobSeeker().get(0));
		when(jobSeekerRepository.findById(1)).thenReturn(jobSeekers);
		JobSeeker jobSeeker = jobSeekerService.update(jobSeekers.get(), 1);
		assert(jobSeekers.get()==jobSeeker);
		
	}

	private List<JobSeeker> createMockJobSeeker() {
		Job job = createJobMockData().get(0);
		List<Skillset> skillsets = new ArrayList<Skillset>();
		skillsets.add(new Skillset(1, "Java", "Intermediate", null));
		List<AppliedJob> appliedJobs = new ArrayList<AppliedJob>();
		appliedJobs.add(new AppliedJob(1, null, job));

		List<JobSeeker> jobSeekers = new ArrayList<>();
		
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setJobseeker_Id(1);
		jobSeeker.setJobseekerName("Jhon");
		jobSeeker.setAddress("India");
		jobSeeker.setContactNumber("123-456-7891");
		jobSeeker.setEmail("jhon@gmail.com");
		jobSeeker.setLocationPreference("India");
		jobSeeker.setUsername("jhon");
		jobSeeker.setPassword("jhon123");
		jobSeeker.setAppliedjobs(null);
		jobSeeker.setSkillSet(skillsets);
		jobSeekers.add(jobSeeker);

		return jobSeekers;
	}
	
	
	/*
	 * private List<AppliedJob> createMockAppliedJobs() { List<AppliedJob>
	 * appliedJobs = new ArrayList<>(); List<Job> jobs = createJobMockData();
	 * //List<Skillset> skillsets = createMockSkillSet();
	 * 
	 * JobSeeker jobSeeker = new JobSeeker(); jobSeeker.setJobseeker_Id(1);
	 * jobSeeker.setJobseekerName("Jhon"); jobSeeker.setAddress("India");
	 * jobSeeker.setContactNumber("123-456-7891");
	 * jobSeeker.setEmail("jhon@gmail.com");
	 * jobSeeker.setLocationPreference("India"); jobSeeker.setUsername("jhon");
	 * jobSeeker.setPassword("jhon123"); jobSeeker.setAppliedjobs(null);
	 * jobSeeker.setSkillSet(null);
	 * 
	 * AppliedJob appliedJob = new AppliedJob(); appliedJob.setId(1);
	 * appliedJob.setJob(jobs.get(0)); appliedJob.setJobseeker(jobSeeker);
	 * appliedJobs.add(appliedJob); return appliedJobs; }
	 * 
	 * private List<Skillset> createMockSkillSet() { List<Skillset> skillsets = new
	 * ArrayList<>(); List<AppliedJob> appliedJobs = createMockAppliedJobs();
	 * 
	 * JobSeeker jobSeeker = new JobSeeker(); jobSeeker.setJobseeker_Id(1);
	 * jobSeeker.setJobseekerName("Jhon"); jobSeeker.setAddress("India");
	 * jobSeeker.setContactNumber("123-456-7891");
	 * jobSeeker.setEmail("jhon@gmail.com");
	 * jobSeeker.setLocationPreference("India"); jobSeeker.setUsername("jhon");
	 * jobSeeker.setPassword("jhon123"); jobSeeker.setAppliedjobs(null);
	 * jobSeeker.setSkillSet(null); Skillset skillset = new Skillset();
	 * 
	 * skillset.setId(1); skillset.setSkill("Java");
	 * skillset.setSkillLevel("Intermediate"); skillset.setJobSeeker(jobSeeker);
	 * skillsets.add(skillset);
	 * 
	 * return skillsets; }
	 */
	 
	  private List<Job> createJobMockData() { List<Job> jobs = new ArrayList<>();
	  Job job = new Job(); job.setAppliedJob(null);
	  job.setContactNo("080-888-7777"); job.setDescription("Work");
	  job.setEmail("a@gmail.com"); job.setEmployer(null); job.setExperience("1");
	  job.setFavourite(Boolean.TRUE); job.setId(1); job.setJobseeker_id(1);
	  job.setLocation("India"); job.setNoticePeriod("1"); job.setSalary(200000);
	  job.setSkillSet("Java"); job.setStatus("open"); job.setTitle("SE");
	  jobs.add(job);
	  
	  return jobs; }
	 
}
