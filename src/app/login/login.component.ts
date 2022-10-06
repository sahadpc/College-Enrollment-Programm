import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register-user.service';
import { User } from '../signup/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User = new User();
  

  constructor(private registerService: RegisterService,private rew:Router) { }


 
  loginUser()
  {
    console.log(this.user)
    this.registerService.loginnUser(this.user.email,this.user.password).subscribe((data:any)=>{
      localStorage.setItem('userToken',data.accessToken)
      alert("Login Successfull ");
      this.registerService.datails(this.user.email).subscribe((data:any)=>{
        localStorage.setItem('das',JSON.stringify(data));
      this.rew.navigate(["user"]);
      })
   },error=>alert("Invalid Login attempt"))
  }

  ngOnInit(): void {
  }

  


}
