import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register-user.service';
import { User } from '../signup/User';
import { Router } from '@angular/router';




@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user:User = new User();
  constructor(private registerService: RegisterService,private rew:Router) { }

  ngOnInit(): void {
  }
  userRegister(){
    let postbody={
      "firstName": this.user.firstname,
      "middleName": this.user.middlename,
      "lastName": this.user.lastname,
      "mobileNumber": this.user.mobile,
      "emailId": this.user.email,
      "userPassword": this.user.password,
          "studentMarks": {
        "sscMarks": this.user.sscpercentage
      },
      "address": [{
        "city": this.user.city,
        "pincode": this.user.pincode,
        "state": this.user.state
      }]
    };
    
    console.log(postbody);
    this.registerService.registerUser(postbody).subscribe(data=>{
      console.log(data)
      alert("Successfully registered? ");
      this.rew.navigate(['login']);
      
      
   },error=>alert("User not registered"));
  }

  onSubmit(): void {
    console.log(JSON.stringify(this.user, null, 2));
  }

  clicks():void{
    
  
  }

  

}
