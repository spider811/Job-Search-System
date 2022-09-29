package com.cg.jss.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.jss.entity.Employer;
import com.cg.jss.entity.Job;
import com.cg.jss.repository.EmployerRepository;
import com.cg.jss.repository.JobRepository;
import com.cg.jss.serviceimpl.EmployerServiceImpl;
import com.cg.jss.serviceimpl.JobServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployerServiceTest {

	@Mock
	EmployerRepository employerRepository;

	@InjectMocks
	EmployerServiceImpl employerService;
	@Mock
	JobRepository jobRepository;

	@InjectMocks
	JobServiceImpl jobService;

	@Test
	public void testGetAllEmployers() {
		List<Employer> employersMockData = createEmployerMockData();
		when(employerRepository.findAll()).thenReturn(employersMockData);
		List<Employer> employersList = employerService.getAllEmployers();
		assert (employersList.size() == employersMockData.size());

	}

	private List<Employer> createEmployerMockData() {
		Employer employer = new Employer();
		List<Employer> employers = new ArrayList<>();
		employer.setId(1);
		employer.setOrganizationName("Capgemini");
		employer.setAddress("Bangalore");
		employer.setEmail("capgemini@gmail.com");
		employer.setContactNumber("123-456-7890");
		employer.setUsername("user");
		employer.setPassword("password");
		employer.setJob(null);
		employers.add(employer);
		return employers;
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

	@Test
	void testGetEmployerByOrganization() {
		List<Employer> employerMockData = createEmployerMockData();
		when(employerRepository.findByOrganizationName("Capgemini")).thenReturn(employerMockData);
		List<Employer> employers = employerService.getEmployerByOrganization("Capgemini");
		assert (employers.size() == employerMockData.size());
	}

	@Test
	void testDeleteJobById() {
		jobService.deleteJobById(1);
		verify(jobRepository, times(1)).deleteById(1);
	}

	/*
	 * @Test void testpostAJob() { Optional<Job> jobsMockData =
	 * Optional.of(createJobMockData().get(0)); Employer
	 * employer=employerRepository.findById(1).get();
	 * employerService.postAjob(jobsMockData.get(),1);
	 * verify(employerRepository,times(1)).findById(1);
	 * verify(employerRepository,times(1)).save(employer); }
	 */

}
