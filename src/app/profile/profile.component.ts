import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, NgbModalConfig} from '@ng-bootstrap/ng-bootstrap';
import { Address } from './Address';
import { RegisterService } from '../register-user.service';
import { toInteger } from '@ng-bootstrap/ng-bootstrap/util/util';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);
  address:Address=new Address();
  addressList!:any[];
  editUserId : any

  constructor(private rout:Router,private modalService: NgbModal,config: NgbModalConfig,private registerService: RegisterService) {
    config.backdrop = 'static';
    config.keyboard = true;
  }

  open(content: any) {
    this.modalService.open(content);
  }

  ngOnInit(): void {
    const getId = this.registerService.userIdd();
    console.log(getId)
    this.registerService.getAllAddress(this.sess.userId).subscribe((data:any)=>{
      this.addressList=data
      console.log(this.addressList)
    }
    
    );
  }
  
  selectedState: String = "--Choose State--";
  
	States: Array<any> = [
		{ name: 'Kerala', cities: ['Kochi', 'Thiruvananthapuram	', 'Kozhikode','Aluva','Attingal','Manjeri'] },
		{ name: 'TamilNadu', cities: ['Coimbatore','Madurai','Salem','Nagercoil','Pollachi','Karur'] },
		{ name: 'Karnataka', cities: ['Bangalore','Mysore','Mangalore','Shimoga','Chikmagalur','Kolar'] },
		{ name: 'Maharashtra', cities: ['Mumbai','Pune','Nagpur','Navi Mumbai','Amravati','	Barshi'] },
		{ name: 'Andhra Pradesh', cities: ['Visakhapatnam','Vijayawada','Tirupati','Nellore','Mangalagiri','Eluru'] }
	];

  cities: Array<any> = [];
  changeState(state: any) {
    this.cities = this.States.find((cntry: any) => cntry.name == state.target.value).cities; //Angular 11
	}

  LogOut(){
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);
  }
  submitAddress(){
    let postbody={
      "city":this.address.city,
      "state":this.address.state,
      "pincode":this.address.pincode
    }
    console.log(postbody);

    this.registerService.addAddress(postbody,this.sess.userId).subscribe((data:any)=>{
      alert("address added succesfully")

      window.location.reload();
    },error=>alert("Address cannot added")
    
    
    )


}

showid(){
  let postbody={
    "city":this.address.city,
    "state":this.address.state,
    "pincode":this.address.pincode


  }
 // let adData:any=this.registerService.userIdd();
 let adData:any=localStorage.getItem('addressId');
  this.registerService.updateAddress(postbody,this.sess.userId,adData).subscribe((data:any)=>{
    alert("Address Updated Succesfully");
    this.modalService.dismissAll()
    window.location.reload();
  },error=>("Update address failed")
  
  
  )

 
}

showidd(adId:any){
  localStorage.setItem('addressId',adId);
//  console.log(data)
//   this.address.pincode = data.pincode;
//   this.address.state = data.pincode;
//   this.address.city = data.city;
 }

 showiddd(adId:any){
  console.log("ki");
  this.registerService.addressIdd=adId;

 }

deleteAdd(adId:any){
  //let adData:any=localStorage.getItem('addressId')
 // console.log(adData);
// let adData:number=this.registerService.addressIddd();
  this.registerService.deleteAddress(this.sess.userId,adId).subscribe((data:any)=>{
    
    console.log(data);
      alert("address deleted succesfully")
      window.location.reload();
     },error=>alert("Failure in delete address")
     
  )
}
}
