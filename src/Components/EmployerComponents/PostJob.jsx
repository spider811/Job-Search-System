import React, { useState } from 'react';
import EmployerNav from '../EmployerNav';
import EmployerService from '../../Service/EmployerService';
import { Button } from 'react-bootstrap';
//import { useNavigate } from 'react-router-dom';

 const  PostJob = (props) => {
  const [empId, setEmpId] = useState('');
  const [title, setTitle] = useState('');
  const [company, setCompany] = useState(sessionStorage.getItem('id'));
  const [noticePeriod, setNoticePeriod] = useState('');
  const [location, setLocation] = useState('');
  const [description, setDescription] = useState('');
  const [experience, setExperience] = useState('');
  const [salary, setSalary] = useState('');
  const [status, setStatus] = useState('');
  const [email, setEmail] = useState('');
  const [contactNo, setContactNo] = useState('');
  const [skillset, setSkillset] = useState('');
 // const history = useNavigate();


  const handleSubmit = (e) => {
    e.preventDefault();
    
    console.log(email);
}

const post= (e)=>{
  e.preventDefault();
     console.log("here");
      alert(title);
      const job = {
          title:title,
          company:company,
          location:location,
          description:description,
          experience:experience,
          salary:salary,
          noticePeriod:noticePeriod,
          status:status,
          email:email,
          skillSet:skillset,
          contactNo:contactNo
          
         
         
      };
      console.log(job);
      
      EmployerService.postAJob(job,empId).then(response =>{
        const {data} = response;
        alert("Job has been posted",data.name);
        props.history.post("/employer/jobs")   
      }).catch(error=>{
        alert("error",error);
      }); 
    }

  return (
    <div><EmployerNav/>
     <h2 align="center">Post Job Details</h2>
    <div className="login">
     
    <form className="register-form" onSubmit={handleSubmit} >
            <label htmlFor="employerid">Employer Id:</label>
            <input value={empId} onChange={(e) => setEmpId(e.target.value)} type="text" name="empId" id="empId" placeholder="empId" required/>
            <label htmlFor="title">Job Title:</label>
            <input value={title} onChange={(e) => setTitle(e.target.value)} type="text" name="title" id="title" placeholder="title" required/>
            <label htmlFor="company">Company</label>
            <input value={sessionStorage.getItem('id')} onChange={(e) => setCompany(e.target.value)} type="text" name="company" id="company" placeholder="company" required/>
            <label htmlFor="location">Location</label>
            <input value={location} onChange={(e) => setLocation(e.target.value)}type="text" placeholder="location" id="location" name="address" required/>
            <label htmlFor="description">Description</label>
            <input value={description} onChange={(e) => setDescription(e.target.value)}type="text" placeholder="description" id="description" name="description" required/>
            <label htmlFor="experience">Experience</label>
            <input value={experience} onChange={(e) => setExperience(e.target.value)} type="text" placeholder="experience" id="experience" name="experience" required/>
            <label htmlFor="salary">Salary</label>
            <input value={salary} onChange={(e) => setSalary(e.target.value)} type="number" placeholder="salary" id="salary" name="salary" required/>
            
             <label htmlFor="noticePeriod">Notice Period</label>
            <input value={noticePeriod} onChange={(e) => setNoticePeriod(e.target.value)} type="text" name="noticePeriod" id="noticePeriod" placeholder="noticePeriod" required/> 
            <label htmlFor="status">Status</label>
            <input value={status} onChange={(e) => setStatus(e.target.value)} type="text" placeholder="status" id="status" name="status" required/>
        
            <label htmlFor="email">Email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="your_email@gmail.com" id="email" name="email" required/>
            
            <label htmlFor="skillset">Skillset</label>
            <input value={skillset} onChange={(e) => setSkillset(e.target.value)} type="text" placeholder="skillset" id="skillset" name="skillset" required/>
            <label htmlFor="contact_no">Contact_no</label>
            <input value={contactNo} onChange={(e) => setContactNo(e.target.value)}type="text" placeholder="contactNo" id="contactNo" name="contactNo" required />
            
            <br/>
            
            <Button variant="outline-success" onClick={post} >Post</Button> 
  </form>
  </div>
    </div>
  )
}

export default PostJob