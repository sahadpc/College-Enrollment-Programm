import { Component, OnInit } from '@angular/core';
import { User } from '../signup/User';

@Component({
  selector: 'app-usercourses',
  templateUrl: './usercourses.component.html',
  styleUrls: ['./usercourses.component.css']
})
export class UsercoursesComponent implements OnInit {

  user:User = new User();
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  courses:any=localStorage.getItem('course');
  courseslist:any=JSON.parse(this.courses);
  constructor() { }

  ngOnInit(): void {
  }

}
