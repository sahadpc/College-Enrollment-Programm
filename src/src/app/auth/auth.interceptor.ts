import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register-user.service';
import { Observable, Observer } from 'rxjs';
import { HttpInterceptor, HttpRequest, HttpHandler,HttpUserEvent,HttpEvent, HttpHeaders } from '@angular/common/http';


@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    constructor(private router:Router,private service:RegisterService){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const getToken=this.service.getToken();
        if(getToken){
          const requestWithToken=req.clone({
            headers:new HttpHeaders({
              Authorization: `Bearer ${getToken}`  ,
              'Content-Type':'application/json',
            }),
          });
          return next.handle(requestWithToken);
        }
        return next.handle(req);
        }
   
        
    }
    
