import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Subscription } from 'rxjs';
import { NgForm } from '@angular/forms';
import { FnParam } from '@angular/compiler/src/output/output_ast';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit,OnDestroy {
  
  loadingAnimation = false;
  hide = true;
  private authStatusSub: Subscription;
  bearerToken:string;  
  errMessage:string;
  userName:string;
  password:string;
  constructor(public authService:AuthenticationService,
    private routerservice:RouterService) { }

  ngOnInit() {
    sessionStorage.removeItem('token');
    this.authStatusSub = this.authService.getAuthStatusListener().subscribe(
      authStatus => {
        this.loadingAnimation = false;
      }
    );
  }
  onLogin(form: NgForm) {
    if (form.invalid) {
      return;
    }
    this.loadingAnimation = true;
    this.userName=form.value.userName;
    this.password=form.value.password;
    console.log("userName:"+form.value.userName+" password:"+form.value.password);
    //this.authService.login(form.value.userName, form.value.password);
    this.authService.login(form.value.userName, form.value.password).subscribe(
      res=>{
        //console.log('res::'+res.message);
        //this.loadingAnimation = true;
        this.authService.authStatusListener.next(true);
       this.bearerToken=res['token'];
        console.log(this.bearerToken);
        this.authService.setBearerToken(this.bearerToken);
        console.log("Welcome token stored");
        this.routerservice.routeToDashboard();
        
      },
      err=>{
        if(err.status === 401)
        {
          this.authService.authStatusListener.next(false);
          this.errMessage = err.error.message;
          this.routerservice.routeToLogin();
          console.log(err.error.message);
        }
        else
        {
          this.authService.authStatusListener.next(false);
          this.errMessage = err.message;
          //this.routerservice.routeToLogin();
          console.log(err.message);
        }
      })
  }

  ngOnDestroy() {
    this.authStatusSub.unsubscribe();
  }

}
