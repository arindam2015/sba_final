import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit,OnDestroy {
  loadingAnimation = false;
  private authStatusSub: Subscription;
  hide = true;

  constructor(public authService:AuthenticationService) { }

  ngOnInit() {
    this.authStatusSub = this.authService.getAuthStatusListener().subscribe(
      authStatus => {
        this.loadingAnimation = false;
      }
    );
  }

  onSignup(form: NgForm) {
    if (form.invalid) {
      return;
    }
    this.loadingAnimation = true;
    this.authService.createUser(form.value.uName, form.value.fName,form.value.lName,form.value.userRole,form.value.password);
      
  }

  ngOnDestroy() {
    this.authStatusSub.unsubscribe();
  }


}
