import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, NgbModalConfig} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  data:any=localStorage.getItem('das');
  sess:any=JSON.parse(this.data);

  constructor(private rout:Router,private modalService: NgbModal,config: NgbModalConfig) {
    config.backdrop = 'static';
    config.keyboard = true;
  }

  open(content: any) {
    this.modalService.open(content);
  }

  ngOnInit(): void {
    
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
}
