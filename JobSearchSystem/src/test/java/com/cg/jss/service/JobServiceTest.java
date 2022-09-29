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

import com.cg.jss.entity.Job;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.serviceimpl.JobServiceImpl;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {
	
	@Mock
	JobRepository jobRepository;
	
	@InjectMocks
	JobServiceImpl jobService;
	
	@Test
	void testGetAllJobs()
	{
		List<Job> jobsMockData = createJobMockData();
		when(jobRepository.findAll()).thenReturn(jobsMockData);
		List<Job> jobs = jobService.getAllJobs();
		assert(jobs.size()==jobsMockData.size());
	}
	
	@Test
	void testGetJobById()
	{
		Optional<Job> job = Optional.of(createJobMockData().get(0));
		when(jobRepository.findById(1)).thenReturn(job);
		Job job2 = jobService.searchByJobId(1);
		assert(job.get()==job2);
	}
	
	@Test
	void testGetJobsBySkill()
	{
		List<Job> jobsMockData = createJobMockData();
		when(jobRepository.findBySkillSet("Java")).thenReturn(jobsMockData);
		List<Job> jobs = jobService.searchJobBySkill("Java");
		assert(jobs.size()==jobsMockData.size());
	}
	
	@Test
	void testGetJobsByTitle()
	{
		List<Job> jobsMockData = createJobMockData();
		when(jobRepository.findByTitle("SE")).thenReturn(jobsMockData);
		List<Job> jobs = jobService.searchJobByTitle("SE");
		assert(jobs.size()==jobsMockData.size());
	}
	
	@Test
	void testGetJobsByLocation()
	{
		List<Job> jobsMockData = createJobMockData();
		when(jobRepository.findByLocation("India")).thenReturn(jobsMockData);
		List<Job> jobs = jobService.searchJobByLocation("India");
		assert(jobs.size()==jobsMockData.size());
	}
	
	@Test
	void testViewFromBasket()
	{
		List<Job> jobsMockData = createJobMockData();
		when(jobRepository.findByFavourite(Boolean.TRUE)).thenReturn(jobsMockData);
		List<Job> jobs = jobService.viewFromBasket();
		assert(jobs.size()==jobsMockData.size());
	}
	
	@Test
	void testUpdateJob()
	{
		Optional<Job> jobsMockData = Optional.of(createJobMockData().get(0));
		when(jobRepository.findById(1)).thenReturn(jobsMockData);
		Job job = jobService.updateJob(1, jobsMockData.get());
		assert(job==jobsMockData.get());
	}
	
	@Test
	void testAddToBasket()
	{
		Optional<Job> jobsMockData = Optional.of(createJobMockData().get(0));
		when(jobRepository.findById(1)).thenReturn(jobsMockData);
		jobService.addToBasket(1);
		verify(jobRepository,times(1)).findById(1);
		verify(jobRepository,times(1)).save(jobsMockData.get());
	}
	@Test
	void testRemoveToBasket()
	{
		Optional<Job> jobsMockData = Optional.of(createJobMockData().get(0));
		when(jobRepository.findById(1)).thenReturn(jobsMockData);
		jobService.removeFromBasket(1);
		verify(jobRepository,times(1)).findById(1);
		verify(jobRepository,times(1)).save(jobsMockData.get());
	}
	
	@Test
	void testDeleteJob()
	{
		jobService.deleteJobById(1);
		verify(jobRepository,times(1)).deleteById(1);
	}

	private List<Job> createJobMockData() {
		List<Job> jobs = new ArrayList<>();
		Job job = new Job();
		job.setAppliedJob(null);
		job.setContactNo("080-888-7777");
		job.setDescription("Work");
		job.setEmail("a@gmail.com");
		job.setEmployer(null);
		job.setExperience("1");
		job.setFavourite(Boolean.TRUE);
		job.setId(1);
		job.setJobseeker_id(1);
		job.setLocation("India");
		job.setNoticePeriod("1");
		job.setSalary(200000);
		job.setSkillSet("Java");
		job.setStatus("open");
		job.setTitle("SE");
		jobs.add(job);
		
		return jobs;
	}
	

}
