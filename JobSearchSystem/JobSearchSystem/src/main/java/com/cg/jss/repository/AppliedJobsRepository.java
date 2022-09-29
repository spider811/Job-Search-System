package com.cg.jss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.jss.entity.AppliedJob;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;

public interface AppliedJobsRepository extends JpaRepository<AppliedJob, Integer> {
 List<AppliedJob> findByJob(Job job);
 List<AppliedJob> findByJobseeker(JobSeeker jobseeker);
}
