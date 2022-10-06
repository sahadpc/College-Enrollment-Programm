import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register-user.service';
import { User } from '../signup/User';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  user:User = new User();
  constructor(private registerService: RegisterService,private rew:Router) { }

  forgetpassword(){
    console.log(this.user.email)
    this.registerService.forgotPassword(this.user.email).subscribe((data:any)=>{
      this.rew.navigate(['/login']);
    })
  }
  ngOnInit(): void {
  }

}
