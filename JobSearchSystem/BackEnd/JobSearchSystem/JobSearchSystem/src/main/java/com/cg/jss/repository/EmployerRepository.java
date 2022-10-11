package com.cg.jss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jss.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Integer> {
	public List<Employer> findByOrganizationName(String organizationName);
}
