import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from '../signup/User';
import { UserdashboardserviceService } from '../userdashboardservice.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
  user:User = new User();
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  constructor(private userdashboardService:UserdashboardserviceService,private rout:Router) { }

  ngOnInit(): void {
  }
  changePassword(){
   console.log(this.sess.userId, this.user.CurrentPassword,this.user.password,this.user.confirmpassword);
   alert("Password Changed Sucessfully");
   this.userdashboardService.changePassword(this.user.CurrentPassword,this.user.password).subscribe((data:any)=>{
    alert("Password Changed Sucessfully");
    this.rout.navigate(['login']);
   },error=>alert("try Again!"))
  }

}
