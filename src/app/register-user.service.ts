import { HttpClient, HttpEvent, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { User } from './signup/User';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseUrl="http://localhost:7079/api/";
  
  constructor( private httpClient:HttpClient ) {  }

  forgotPassword(email:string):Observable<any>{
    let params = new HttpParams();
    params = params.append('email',email);
    return this.httpClient.get(`${this.baseUrl}`+'forgetPassword',{params:params})
  }
  registerUser( user: object ): Observable<Object>{
    console.log( user );
    return this.httpClient.post(`${this.baseUrl}`+'register', user);
  }

  loginnUser(email:string,password:string):Observable<object>{
    let params = new HttpParams();
    // Begin assigning parameters
    params = params.append('email', email);
    params = params.append('password', password);
     return this.httpClient.get(`${this.baseUrl}`+'auth/login',{params:params})
  }
  getToken(){
    return localStorage.getItem('userToken');
  }
  datails(email:string):Observable<object>{
   // let header=new HttpHeaders().set('Authorization','Bearer'+localStorage.getItem('userToken'));
    let params = new HttpParams();
    // Begin assigning parameters
    params = params.append('email', email);
    return this.httpClient.get(`${this.baseUrl}`+'getbyemail',{params:params})
  }
  //,{Headers:new HttpHeaders({'Authorization':'Bearer'+localStorage.getItem('userToken')})}
}