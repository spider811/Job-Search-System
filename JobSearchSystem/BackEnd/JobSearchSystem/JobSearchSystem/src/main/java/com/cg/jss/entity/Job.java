package com.cg.jss.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Job")
@JsonIgnoreProperties(value= {"id"},allowGetters=true)
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotBlank(message = "Name must not be null and empty")
	@Column(name="job_title")
	private String title;
	
	@NotBlank(message = "Company must not be null and empty")
	@Column(name="company")
	private String company;
	
	
	@NotBlank(message = "Location must not be null and empty")
	@Column(name="location")
	private String location;
	
	@NotBlank(message = "Description must not be null and empty")
	@Column(name="description")
	private String description;
	
	@NotBlank(message = "Experience must not be null and empty")
	@Column(name="experience")
	private String experience;
	
	@NotNull(message = "Salary must not be null and empty")
	@Column(name="salary")
	private double salary;
	
	@NotBlank(message = "Notice Period must not be null and empty")
	@Column(name="notice_period")
	private String noticePeriod;
	
	@NotBlank(message = "Status must not be null and empty")
	@Column(name="status")
	private String status;
	
	@NotBlank(message = "email must not be null and empty")
	@Email
	@Column(name="email")
	private String email;
	
	@NotBlank(message = "Skill must not be null and empty")
	@Column(name="skillSet")
	private String skillSet;
	
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
	@Column(name="contactNo")
	private String contactNo;
	
	
	@Column(name="favourite")
	private Boolean favourite = Boolean.FALSE; 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employer employer;
	
	@JsonIgnore
	@Column(name="jobseeker_id", nullable = false)
	private int jobseeker_id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker", cascade = CascadeType.ALL)
	private List<AppliedJobs> appliedJob;
}


