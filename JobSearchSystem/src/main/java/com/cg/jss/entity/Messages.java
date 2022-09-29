package com.cg.jss.entity;

import java.sql.Date;

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
@Table(name="Messages")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="description")
    private String description;
	

	/* @ManyToOne
	@JoinColumn(name="jobseeker_id")
    private JobSeeker jobseekerId;
    
	 @ManyToOne
	 @JoinColumn(name="employer_id")
    private Employer employerId ;*/
	 
	 @Column(name="date")
    private Date date;
}
