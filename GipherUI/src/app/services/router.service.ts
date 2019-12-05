import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router:Router) { }
  routeToDashboard() {
    this.router.navigate(['dashboard']);
  }

  routeToLogin() {
    console.log('route to login');
  	this.router.navigate(['login']);
  }
  routeToBookmark() {
    console.log('route to bookmark');
  	this.router.navigate(['bookmark']);
  }
  routeToRecommand() {
    console.log('route to recommand');
  	this.router.navigate(['recommandedBookmark']);
  }
}
