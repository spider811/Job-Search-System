package com.cg.jss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jss.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
	
	List<Job> findByTitle(String title);
	List<Job> findByLocation(String location);
	List<Job> findByFavourite(Boolean favourite);
	List<Job> findBySkillSet(String skill);

}
