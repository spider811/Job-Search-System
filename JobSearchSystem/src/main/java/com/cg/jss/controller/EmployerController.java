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

import com.cg.jss.entity.Employer;
import com.cg.jss.entity.Job;
import com.cg.jss.entity.JobSeeker;
import com.cg.jss.service.EmployerService;
import com.cg.jss.service.JobService;


@RestController
@RequestMapping("/api/v2")
public class EmployerController {
	@Autowired
	EmployerService employerService;
	@Autowired
	JobService jobService;
	
	@Validated
	@PostMapping("/employers")
	public ResponseEntity<String> registerEmployer(@RequestBody @Valid Employer employer) {
		Employer registerEmployer=employerService.registerEmployer(employer);
		return new ResponseEntity<String>("Employeer registered with id "+registerEmployer.getId(),HttpStatus.CREATED);
	}
	@Validated
	@PostMapping("/job")
	public ResponseEntity<Job> postAJob(@RequestBody  @Valid Job job,Integer id) {
		Job postJob=employerService.postAjob(job, id);
		return new ResponseEntity<>(postJob,HttpStatus.CREATED);
	}
	@GetMapping("/job")
	public ResponseEntity<List<Job>> getAllJobs(){
		List<Job> jobList=employerService.getAllJobs();
		return new ResponseEntity<>(jobList,HttpStatus.OK);
		
	}
	@GetMapping("/jobs/{job_id}")
	public ResponseEntity<Job> getJobById(@PathVariable Integer job_id){
		Job job=employerService.getJobById(job_id);
		return new ResponseEntity<>(job,HttpStatus.OK);
		
	}
	@DeleteMapping("/jobs/{job_id}")
	public ResponseEntity<Job> deleteJobById(@PathVariable Integer job_id){
		employerService.deleteJobById(job_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/jobseekers/skills/{skill}")
	public ResponseEntity<List<JobSeeker>> searchJobSeekerBySkills(@PathVariable("skill") String skill)
	{
		return new ResponseEntity<List<JobSeeker>>(employerService.searchJobSeekerBySkills(skill),HttpStatus.OK);
	}
	@Validated
	@PutMapping("/jobs/{id}")
	public ResponseEntity<Job> editAJob(@RequestBody  @Valid Job job,@PathVariable("id") Integer id) {
		Job updatedjob=jobService.updateJob(id, job);
		return new ResponseEntity<>(updatedjob,HttpStatus.OK);
	}
	@GetMapping("/jobseeker/job/{jobid}")
	public ResponseEntity<List<JobSeeker>> searchJobSeekerByJobId(@PathVariable("jobid") Integer jobId)
	{
		return new ResponseEntity<List<JobSeeker>>(employerService.searchJobSeekerByJobId(jobId),HttpStatus.OK);
	}
	@GetMapping("/employers/{organizationName}")
	public ResponseEntity<List<Employer>> getEmployerByOrganization(@PathVariable("organizationName") String organizationName)
	{
		List<Employer> employerList=employerService.getEmployerByOrganization(organizationName);
		return new ResponseEntity<List<Employer>>(employerList,HttpStatus.OK);
	}
	
	@GetMapping("/employers")
	public ResponseEntity<List<Employer>> getAllEmployers(){
		List<Employer> employersList=employerService.getAllEmployers();
		return new ResponseEntity<>(employersList,HttpStatus.OK);
	}
}
