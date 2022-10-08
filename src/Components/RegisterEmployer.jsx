import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import EmployerService from "../Service/EmployerService";
import Navbar from "./NavBar";
export const RegisterEmployer = (props) => {
    const [organizationName, setName] = useState('');
    const [address, setAddress] = useState('');
    const [contact_number, setContactNumber] = useState('');
    const [email, setEmail] = useState('');
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
        alert(organizationName);
        const user = {
            organizationName :organizationName,
            address :address,
            contactNumber:contact_number,
            email:email,
            username:username,
            password: password
        };
        console.log(user);
        alert(user.name," Hello");
        EmployerService.createEmployee(user).then(response =>{
          const {data} = response;
          alert("Hello registering of the new account is successful",data.name);
          props.history.push("/login");
        });
        
        
    }
 

    return (
        <div><Navbar/>
        <div className="login">
            <div className="auth-form-container">
            <a className="btn btn-outline-light" href='/registeremployer'><h6>Employer</h6></a>
            <a className="btn btn-outline-light" href='/registerjobseeker'><h6>Job Seeker</h6></a>
            <h2>Register Employer</h2>
        <form className="register-form" onSubmit={handleSubmit}>
            <label htmlFor="name">Organization name</label>
            <input value={organizationName} onChange={(e) => setName(e.target.value)} name="name" id="name" placeholder="Name" />
            <label htmlFor="address">Address</label>
            <input value={address} onChange={(e) => setAddress(e.target.value)}type="text" placeholder="address" id="address" name="address" required/>
            <label htmlFor="contact_no">Contact_no</label>
            <input value={contact_number} onChange={(e) => setContactNumber(e.target.value)}type="text" placeholder="contact_no" id="contact_no" name="contact_no" required />
            <label htmlFor="email">Email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" required/>
            <label htmlFor="username">Username</label>
            <input value={username} onChange={(e) => setUsername(e.target.value)} placeholder="username" id="username" name="username" required/>
            <label htmlFor="password">Password</label>
            <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password"/>
            <br/>
            <button type="submit"  onClick={onSignup} >Register</button>
        </form>
      
        <a className="link-btn" href="/login">Already have an account? Login here.</a>
    </div>
    </div>
    </div>

    )
}