import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userdashboard-landing',
  templateUrl: './dashboardlanding.component.html',
  styleUrls: ['./dashboardlanding.component.css']
})
export class UserdashboardLandingComponent implements OnInit {
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  constructor(private rout:Router) { }
  
  ngOnInit(): void {
  }
  userDashboard(){
    
  }
  changePassword()
  {
    this.rout.navigate(['/user/changepassword']);
  }
  LogOut(){
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
}
