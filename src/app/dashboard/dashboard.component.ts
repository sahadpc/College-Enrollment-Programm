import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../signup/User';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);


  constructor(private rout:Router) { }

  
  ngOnInit(): void {
    
  }
  
  LogOut(){
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
 
  

}
