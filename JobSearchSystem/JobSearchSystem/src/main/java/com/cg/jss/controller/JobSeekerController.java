package com.cg.jss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jss.entity.AppliedJob;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.service.JobSeekerService;
import com.cg.jss.service.JobService;

@RestController
@RequestMapping("/api/v1")
public class JobSeekerController {
	@Autowired
	JobSeekerService jobSeekerService;
	@Autowired
	JobService jobService;
	@Validated
	@PostMapping("/create")
	public ResponseEntity<JobSeeker> registerJobSeeker(@RequestBody @Valid JobSeeker jobSeeker)
	{
		return new ResponseEntity<JobSeeker>(jobSeekerService.registerJobSeeker(jobSeeker),HttpStatus.CREATED);
	}
	@PostMapping("/applyjob/{jobid}/{jobseekerid}")
	public ResponseEntity<String> applyForJob(@PathVariable("jobid")Integer jobId,@PathVariable("jobseekerid")Integer jobSeekerId )
	{
		jobSeekerService.applyAJob(jobId, jobSeekerId);
		return new ResponseEntity<String>("Job Applied",HttpStatus.OK);
	}
	@PutMapping("/basket/{id}")
	public ResponseEntity<Job> addToBasket(@PathVariable("id") Integer jobId)
	{
		jobService.addToBasket(jobId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@Validated
	@PutMapping("/{id}")
	public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable("id") Integer jobSeekerId,@RequestBody @Valid JobSeeker newJobSeeker)
	{
		JobSeeker jobSeeker = jobSeekerService.update(newJobSeeker,jobSeekerId);
		return new ResponseEntity<JobSeeker>(jobSeeker,HttpStatus.OK);
	}
	@DeleteMapping("/basket/{id}")
	public ResponseEntity<Job> removeFromBasket(@PathVariable("id") Integer jobId)
	{
		jobService.removeFromBasket(jobId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/basket")
	public ResponseEntity<List<Job>> viewBasket()
	{
		List<Job>jobs=jobService.viewFromBasket();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<List<Job>> searchByJobLocation(@PathVariable("location") String location)
	{
		List<Job>jobs=jobService.searchJobByLocation(location);
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/skill/{skill}")
	public ResponseEntity<List<Job>> searchByJobSkill(@PathVariable("skill") String skill)
	{
		List<Job>jobs=jobService.searchJobBySkill(skill);
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Job>> searchByJobTitle(@PathVariable("title") String title)
	{
		List<Job>jobs=jobService.searchJobByTitle(title);
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<Job> searchByJobId(@PathVariable("id") Integer jobId)
	{
		Job job=jobService.searchByJobId(jobId);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@GetMapping("/job")
	public ResponseEntity<List<Job>> getAllJob()
	{
		List<Job>jobs=jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/appliedjobs/{jobseekerid}")
	public ResponseEntity<List<Job>> getAllAppliedJobs(@PathVariable("jobseekerid") Integer jobSeekerId)
	{
		List<Job> jobs=jobSeekerService.getAllAppliedJobs(jobSeekerId);
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
}
