import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserdashboardserviceService {
  baseUrl="http://localhost:7079/api/";
  
  constructor( private httpClient:HttpClient ) {  }

  courseEnrollment(userId:number,collegename:string,coursename:string):Observable<Object>
  {
   // console.log(userId,collegename,coursename);
      let params = new HttpParams();
      params = params.append('userId',userId);
      params = params.append('collegename',collegename);
      params = params.append('coursename',coursename);
      return this.httpClient.get(`${this.baseUrl}`+'courseRegister',{params:params})
  }
  changePassword(CurrentPassword:string,password:string):Observable<object>
  {
    let params = new HttpParams();
    params = params.append('CurrentPassword',CurrentPassword);
    params = params.append('password',password);
    return this.httpClient.get(`${this.baseUrl}`+'changePassword',{params:params})
  }

}
