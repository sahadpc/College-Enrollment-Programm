import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../signup/User';
import { UserdashboardserviceService } from '../userdashboardservice.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit 
{
  i:number=0;
  userCourses:Array<string> = new Array();
  user:User = new User();
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  constructor(private rout:Router,private dashboardservice:UserdashboardserviceService) 
  { }
  ngOnInit(): void 
  {
  }
  changePassword()
  {
    this.rout.navigate(['/user/changepassword']);
  }
  userDashboard()
  { 
    console.log(this.sess.userId,this.user.collegename,this.user.coursename);
    // this.dashboardservice.courseEnrollment(this.sess.userId,this.user.collegename,this.user.coursename).subscribe((data:any)=>{
    //   alert("Submit Successfull ");
    // })
    alert("Submit Successfull");
    localStorage.setItem('course',JSON.stringify(this.user));
    this.userCourses[this.i++] = this.user.coursename;
    console.log(this.userCourses);
    localStorage.setItem('courseArray',JSON.stringify(this.userCourses));
    this.rout.navigate(['./user/coursedetails']);
  }
  myCourses()
  {
    localStorage.setItem('course',JSON.stringify(this.user));
    console.log(this.user.collegename);
    this.rout.navigate(['./user/coursedetails']);
  }
  LogOut()
  {
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
}
