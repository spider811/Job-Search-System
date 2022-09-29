package com.cg.jss.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.cg.jss.entity.Employer;

class EmployerTest {

	Employer employer = mock(Employer.class);
	//employer employer = new employer();
	@Test
	public void testsetUserName() {

		employer.setUsername("Vikas");
		when(employer.getUsername()).thenReturn("Vikas");

		assertEquals(employer.getUsername(), "Vikas");
	}

	@Test
	public void testsetPassword() {

		employer.setPassword("password");
		when(employer.getPassword()).thenReturn("password");

		assertEquals(employer.getPassword(), "password");
	}
	
	
	@Test
	public void testsetOrginazationName() {
		
		employer.setOrganizationName("Capgemini");
		when(employer.getOrganizationName()).thenReturn("Capgemini");
		
		assertEquals(employer.getOrganizationName(), "Capgemini");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		employer.setAddress("Bangalore");
		when(employer.getAddress()).thenReturn("Bangalore");
		
		assertEquals(employer.getAddress(), "Bangalore");
	}
	
	
	
	@Test
	public void testsetEmail() {
		
		employer.setEmail("capgemini@gmail.com");
		when(employer.getEmail()).thenReturn("capgemini@gmail.com");
		
		assertEquals(employer.getEmail(), "capgemini@gmail.com");
	}
}