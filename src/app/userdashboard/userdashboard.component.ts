import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../signup/User';
import { UserdashboardserviceService } from '../userdashboardservice.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  user:User = new User();
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  constructor(private rout:Router,private dashboardservice:UserdashboardserviceService) { }
  ngOnInit(): void {
  }
  changePassword()
  {
    this.rout.navigate(['/changepassword']);
  }
  userDashboard(){
    console.log(this.sess.userId,this.user.collegename,this.user.coursename);
    // this.dashboardservice.courseEnrollment(this.sess.userId,this.user.collegename,this.user.coursename).subscribe((data:any)=>{
    //   alert("Submit Successfull ");
    // })
    alert("Submit Successfull");
  }
  LogOut()
  {
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
}
