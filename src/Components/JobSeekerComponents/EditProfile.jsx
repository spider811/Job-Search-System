import { TextField } from '@mui/material';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import JobSeekerService from '../../Service/JobSeekerService';
import JobSeekerNav from '../JobSeekerNav';


export default function EditProfile(){
    
    const {id} = useParams()
    // const [jobSeekerName, setJobSeekerName]=useState('');
    // const[address, setAddress]=useState('')
    // const[contactNumber, setContactNumber]=useState('')
    // const[email, setEmail]=useState('')
    // const[locationPreference, setLocationPreference]=useState('')
    // const[username,setUserName]=useState('')
    // const[password, setPassword]=useState('')
    const [jobSeeker, setJobseeker]=useState({
        
            
            jobseekerName: '',
            address: '',
            contactNumber: '',
            email: '',
            locationPreference: '',
            username: '',
            password: ''
    })
    const updateJobSeekeer=async(id)=>{
        let jobSeeker=await (await JobSeekerService.getJobSeekerById(id)).data;
        //console.log(jobSeeker);
        setJobseeker(jobSeeker)
    }
    const history = useNavigate();
    //const [job,setJob]=useState('');

    //useEffect(()=>{getJobSeekerById();})
    useEffect(()=>{
        if(id){
            updateJobSeekeer(id)
        }
    },[])

    // const getJobSeekerById=()=>{
    //     JobSeekerService.getJobSeekerById(id).then((response)=>{
    //         setJobSeekerName(response.data.jobseekerName)
    //         setAddress(response.data.address)
    //         setContactNumber(response.data.contactNumber)
    //         setEmail(response.data.email)
    //         setLocationPreference(response.data.locationPreference)
    //         setUserName(response.data.username)
    //         setPassword(response.data.password)
           
    //         //console.log(response.data); 
    //     }).catch(error=>{
    //         console.log(error);
    //     })
    // }
    // const updateJobSeeker=()=>{
    //     const jobSeeker={jobSeekerName,address,contactNumber,email,
    //         locationPreference,username,password}
    //         JobSeekerService.updateJobSeeker(id,jobSeeker).then((response)=>{
    //             alert('Job Seeker updated successfully')
    //             history("/")
    //         }).catch(error=>{
    //             console.log(error);
    //             alert('Update Failed')

    //         })
    // }
    const handleChange=(event)=>{
       setJobseeker({...jobSeeker,[event.target.placeholder]:event.target.value})
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!jobSeeker.jobseekerName.length) {
          return;
        }
        const newItem = {...jobSeeker};
       
          JobSeekerService.updateJobSeeker(id,newItem);
        //setJobseeker(getJobSeekerById(id));
        
        
      }

    return(<div><JobSeekerNav/>
        <div>
            <h2>Update Profile</h2>
            <form onSubmit={handleSubmit}>
                {jobSeeker.jobseekerName}
            <TextField placeholder='jobseekerName'
              onChange={handleChange}
              value={jobSeeker.jobseekerName}
            /><br/><br/>
           <input placeholder='email'
              onChange={handleChange}
              value={jobSeeker.email}
            /><br/><br/>
              <input placeholder='contactNumber'
              onChange={handleChange}
              value={jobSeeker.contactNumber}
            /><br/><br/>
              <input placeholder='address'
              onChange={handleChange}
              value={jobSeeker.address}
            /><br/><br/>
            <input placeholder='locationPreference'
              onChange={handleChange}
              value={jobSeeker.locationPreference}
            /><br/><br/>
            <input placeholder='username'
              onChange={handleChange}
              value={jobSeeker.username}
            /><br/><br/>
            <input placeholder='password'
              onChange={handleChange}
              value={jobSeeker.password}
            /><br/><br/>
            <button onClick={handleSubmit}>Update</button>
            &nbsp;&nbsp;
            
          </form><br/><br/>
        </div>
        </div>
    );
}