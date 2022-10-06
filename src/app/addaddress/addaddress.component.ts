import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-addaddress',
  templateUrl: './addaddress.component.html',
  styleUrls: ['./addaddress.component.css']
})
export class AddaddressComponent implements OnInit {

  constructor(private rout:Router,private title: Title) { }

  ngOnInit(): void {
    this.title.setTitle('Add Address');
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

  LogOut() {
    localStorage.removeItem('userToken');
    localStorage.removeItem('das');
    this.rout.navigate(['login']);

  }
}