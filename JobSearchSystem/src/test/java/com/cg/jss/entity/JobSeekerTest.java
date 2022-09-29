package com.cg.jss.entity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.cg.jss.entity.JobSeeker;

import static org.junit.jupiter.api.Assertions.*;
public class JobSeekerTest {
	JobSeeker jobSeeker = mock(JobSeeker.class);
	
	@Test
	public void testsetName() {

		jobSeeker.setJobseekerName("Vikas");
		when(jobSeeker.getJobseekerName()).thenReturn("Vikas");

		assertNotEquals(jobSeeker.getJobseekerName(), "Krishna");
	}
	
	@Test
	public void testsetUserName() {

		jobSeeker.setUsername("Vikas");
		when(jobSeeker.getUsername()).thenReturn("Vikas");

		assertEquals(jobSeeker.getUsername(), "Vikas");
	}

	@Test
	public void testsetPassword() {

		jobSeeker.setPassword("password");
		when(jobSeeker.getPassword()).thenReturn("password");

		assertEquals(jobSeeker.getPassword(), "password");
	}
	
	@Test
	public void testsetEmail() {

		jobSeeker.setEmail("vikas@gmail.com");
		when(jobSeeker.getEmail()).thenReturn("vikas@gmail.com");

		assertEquals(jobSeeker.getEmail(), "vikas@gmail.com");
	}
	@Test
	public void testsetContact() {

		jobSeeker.setContactNumber("656-454-6788");
		when(jobSeeker.getContactNumber()).thenReturn("656-454-6788");

		assertNotEquals(jobSeeker.getContactNumber(), "032-455-6789");
	}
}
