package com.cg.jss.entity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import com.cg.jss.entity.Job;

public class JobTest {
	
	Job job=mock(Job.class) ;
	@Test
	public void testsetJobTitle() {
	
		job.setTitle("Analyst");
		when(job.getTitle()).thenReturn("Analyst");
		
		assertEquals(job.getTitle(), "Analyst");
	}
	@Test
	public void testsetSkillset() {
		
		
		job.setSkillSet("Java");
		when(job.getSkillSet()).thenReturn("Java");
		
		assertNotEquals(job.getSkillSet(), "Python");
	}
	
	
	@Test
	public void testsetDescription() {
		
		job.setDescription("This is Service Based Company");
		when(job.getDescription()).thenReturn("This is Service Based Company");
		
		assertEquals(job.getDescription(), "This is Service Based Company");
	}
	
	@Test
	public void testsetLocation() {
		
		
		job.setLocation("Bangalore");
		when(job.getLocation()).thenReturn("Bangalore");
		
		assertEquals(job.getLocation(), "Bangalore");
	}
}
