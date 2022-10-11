package com.cg.jss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Applied_Jobs")
public class AppliedJobs {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="apply_job_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobseeker;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
}

