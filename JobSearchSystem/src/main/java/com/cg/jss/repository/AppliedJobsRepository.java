package com.cg.jss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jss.entity.AppliedJobs;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
@Repository
public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Integer> {
 List<AppliedJobs> findByJob(Job job);
 List<AppliedJobs> findByJobseeker(JobSeeker jobseeker);
}
