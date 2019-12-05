import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';
import { SignupComponent } from './signup/signup.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { RecommandComponent } from './recommand/recommand.component';

const routes: Routes = [
  {
  path:'login',component:LoginComponent
  },
  {
    path:'signup',component:SignupComponent
    },
  {
    path:'dashboard',component:DashboardComponent,canActivate:[AuthGuard]
  },
  {
    path:'bookmark',component:BookmarkComponent,canActivate:[AuthGuard]
  },
  {
    path:'recommandedBookmark',component:RecommandComponent,canActivate:[AuthGuard]
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
