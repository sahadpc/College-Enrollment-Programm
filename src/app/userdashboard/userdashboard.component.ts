import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  constructor(private rout:Router) { }
  
  ngOnInit(): void {
  }
  userDashboard(){
    
  }
  LogOut(){
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
}
