import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AngularMaterialModule } from './angular-material.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthenticationService } from './services/authentication.service';
import { RouterService } from './services/router.service';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './auth.guard';
import { HttpModule } from '@angular/http';
import { GipherService } from './services/gipher.service';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { RecommandComponent } from './recommand/recommand.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    DashboardComponent,
    SignupComponent,
    BookmarkComponent,
    RecommandComponent,
    FooterComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    AngularMaterialModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    MatGridListModule
    
  ],
  providers: [AuthenticationService,RouterService,AuthGuard,GipherService],
  bootstrap: [AppComponent]
})
export class AppModule { }
