import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import JobSeekerService from '../../Service/JobSeekerService';
import JobSeekerNav from '../JobSeekerNav'

function JobSeekerProfile() {
  const [jobSeeker,setJobSeeker]=useState('')
  //const {id}= useParams();
  //console.log(id);
  useEffect(()=>{getJobSeekerById();})
  const getJobSeekerById=()=>{
      JobSeekerService.getJobSeekerById(sessionStorage.getItem('id')).then((response)=>{
          setJobSeeker(response.data)
          console.log(response.data);
      }).catch(error => {
          console.log(error);
      })
  }
  // const doEdit=()=>{
  //     navigate()
  // }
  return (
    <div><JobSeekerNav/>
     <div>
      {jobSeeker.jobseeker_Id}<br/>
      {jobSeeker.jobseekerName}<br/>
      {jobSeeker.address}<br/>
      {jobSeeker.contactNumber}<br/>
      {jobSeeker.email}<br/>
      {jobSeeker.locationPreference}<br/>
      {jobSeeker.username}<br/>
      {jobSeeker.password}<br/>
    <Link className="btn btn-outline-success" to={`/EditProfile/${jobSeeker.jobseeker_Id}`} >Edit</Link>
    </div>

    </div>
  )
}

export default JobSeekerProfile