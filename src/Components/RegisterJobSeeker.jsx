import React, { useState } from "react";
import JobSeekerService from "../Service/JobSeekerService";
import Navbar from "./NavBar";

export const RegisterJobSeeker = (props) => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [address, setAddress] = useState('');
    const [contact_no, setContactNo] = useState('');
    const [locationPreference, setLocationPreference] = useState('');
    const [skill, setSkill] = useState('');
    const [skill2, setSkill2] = useState('');
    const [skillLevel, setSkillLevel] = useState('');
    const [skillLevel2, setSkillLevel2] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
  

    const handleSubmit = (e) => {
        e.preventDefault();
        
        console.log(email);
    }

    const saveJobSeeker = (e)=>{
       
      
        console.log(email);
        //EmployeeService.createEmployee(employee).then(res =>{
        //    this.props.history.push('/employees');
        //})
    }  
    
    
   const onSignup = (e)=>{
    e.preventDefault();
        console.log("here");
        alert(name);
        const user = {
            jobseekerName :name,
            address :address,
            contactNumber:contact_no,
            email:email,
            locationPreference:locationPreference,
            username:username,
            password: password,
            skillSet:[{
                skill:skill,
                skillLevel:skillLevel},{
                skill:skill2,
                skillLevel:skillLevel2
        }]
             
            
            
        };
        console.log(user);
        alert(user.name," Hello");
        JobSeekerService.registerJobSeeker(user).then(response =>{
          const {data} = response;
          alert("Hello registering of the new account is successful",data.name);
          props.history.push("/login");
        }).catch(error=>{
          alert("error",error);
        });
        

    }
 

    return (
        <div><Navbar/>
        <div className="login">
            <div className="auth-form-container">
            <a className="btn btn-outline-light" href='/registeremployer'><h6>Employer</h6></a>
            <a className="btn btn-outline-light" href='/registerjobseeker'><h6>Job Seeker</h6></a>
            <h2>Register Job Seeker</h2>
        <form className="register-form" onSubmit={handleSubmit}>
            <label htmlFor="name">Name</label>
            <input value={name} onChange={(e) => setName(e.target.value)} name="name" id="name" placeholder="Name" required/>
    
            <label htmlFor="address">Address</label>
            <input value={address} onChange={(e) => setAddress(e.target.value)}type="text" placeholder="address" id="address" name="address" required/>
            <label htmlFor="contact_no">Contact_no</label>
            <input value={contact_no} onChange={(e) => setContactNo(e.target.value)}type="text" placeholder="000-000-0000" id="contact_no" name="contact_no" required />
            
            <label htmlFor="email">Email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="your_email@gmail.com" id="email" name="email" required/>
           
            <label htmlFor="location">Location</label>
            <input value={locationPreference} onChange={(e) => setLocationPreference(e.target.value)}type="text" placeholder="location" id="location" name="location" required/>
            
            <label htmlFor="skill1">Skill1</label>
            <form>
            
            <input value={skill} onChange={(e) => setSkill(e.target.value)}type="text" placeholder="skill" id="skill" name="skill" required/>
            <label htmlFor="skillLevel1">SkillLevel</label>
            <select value={skillLevel} onChange={(e) => setSkillLevel(e.target.value)}  name="skillLevel1" id="skillLevel1" required> 
            <option value="" hidden>--Select--</option>
                <option value="Beginner">Beginner</option>
                 <option value="Intermediate">Intermediate</option>
                <option value="Advanced">Advanced</option>
            </select>
            </form>
            <label htmlFor="skill2">Skill2</label>
            <form>
            
            <input value={skill2} onChange={(e) => setSkill2(e.target.value)}type="text" placeholder="skill2" id="skill2" name="skill2" required/>
            <label htmlFor="skillLevel2">SkillLevel</label>
            <select value={skillLevel2} onChange={(e) => setSkillLevel2(e.target.value)}  name="skillLevel2" id="skillLevel2" required>
            <option value="" hidden>--Select--</option>
  <option value="Beginner">Beginner</option>
  <option value="Intermediate">Intermediate</option>
  <option value="Advanced">Advanced</option>
</select>
            </form>
            <label htmlFor="username">Username</label>
            <input value={username} onChange={(e) => setUsername(e.target.value)} placeholder="username" id="username" name="username" required />
            <label htmlFor="password">Password</label>
            <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" required/>
            <br/>
            <button v type="submit"  onClick={onSignup} >Register</button>
        </form>
        <a className="link-btn" href="/login">Already have an account? Login here.</a>
        </div>
    </div>
    </div>
    )
}