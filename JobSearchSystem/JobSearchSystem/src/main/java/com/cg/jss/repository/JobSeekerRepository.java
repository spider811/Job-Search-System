package com.cg.jss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jss.entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer>{

}
