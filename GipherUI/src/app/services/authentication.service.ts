import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import {  map, catchError} from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authUrl:string;
  private tokenTimer: any;
  public authStatusListener = new Subject<boolean>();
  private sessionListener = new Subject<boolean>();
  serviceName = 'Auth Service';
  

  constructor(private httpClient:HttpClient,private router: Router) {
    //this.authUrl='http://localhost:9200/gifs';
   //for local
    this.authUrl='http://localhost:8765/user-auth/gifs';
  //when running from docker compose
 //this.authUrl='http://10.0.75.2:8765/user-auth/gifs';
  }
   createUser(uName: string, fName: string,lName:string,userRole:string, password: string) {
    const authData = { userId: uName, firstName: fName, lastName:lName,userRole:userRole,userPassword: password };
    this.httpClient.post<{ token: string }>(this.authUrl + '/register', authData).subscribe(response => {
     // this.setAuthValues(response.token, this.getTokenPayload(response.token));
      this.authStatusListener.next(true);
      this.router.navigate(['/login']);
    }, error => {
      console.log(error);
      this.authStatusListener.next(false);
    });
  }
   login(userName:string,password:string) {
     const authData={userId:userName,userPassword:password};
     sessionStorage.setItem("UserName",userName);
     
     return this.httpClient.post(this.authUrl+'/login',authData);
     
  }

   setBearerToken(token:string) {
    sessionStorage.setItem('bearerToken',token);
  }

  getBearerToken() {
    return sessionStorage.getItem('bearerToken');
  }
  
   getAuthStatusListener() {
    return this.authStatusListener.asObservable();
  }
  getSessionListener() {
    return this.sessionListener.asObservable();
  }
  getIsAuth() {
    return this.getBearerToken()!=null? true : false;
  }
  getName(){
    return sessionStorage.getItem("UserName");
  }
 
  logout() {
    
    sessionStorage.clear();
    this.authStatusListener.next(false);
    //this.clearAuthData();
    clearTimeout(this.tokenTimer);
    this.router.navigate(['/login']);
  }
}
