package com.cg.jss.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="JobSeeker")
public class JobSeeker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name="id")
	private Integer jobseeker_Id;
	@NotBlank(message = "Name must not be null and empty")
	@Column(name="jobseeker_name")
	private String jobseekerName;
	@NotBlank(message = "Address must not be null and empty")
	@Column(name="address")
	private String address;
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
	@Column(name="contact_number")
	private String contactNumber;
	@NotBlank(message = "email must not be null and empty")
	@Email
	@Column(name="email")
	private String email;
	@NotBlank(message = "Location must not be null and empty")
	@Column(name=" location_preference")
	private String locationPreference;
	@NotBlank(message = "User-Name must not be null and empty")
	@Column(name="username")
	private String username;
	@NotBlank(message = "Password must not be null and empty")
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<AppliedJob> appliedjobs;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Skillset> skillSet;
}

