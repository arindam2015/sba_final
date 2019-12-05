import { async, ComponentFixture, TestBed, fakeAsync } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { AngularMaterialModule } from '../angular-material.module';
import { FormsModule, ReactiveFormsModule, FormControl, NgForm } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
import { Router } from '@angular/router';
//import { Observable } from 'rxjs/Observable';
//import 'rxjs/add/observable/of';
//import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs';
const testConfig = {
  error404: {
    message: 'Http failure response forhttp://localhost:8765/user-auth/gifs: 404 Not Found',
    name: 'HttpErrorResponse',
    ok: false,
    status : 404,
    statusText: 'Not Found',
    url: 'http://localhost:8765/user-auth/gifs'
  },
  error403: {
    error: {message: 'Unauthorized'},
    message: 'Http failure response for http://localhost:8765/user-auth/gifs: 403 Forbidden',
    name: 'HttpErrorResponse',
    ok: false,
    status: 403,
    statusText: 'Forbidden',
    url: 'http://localhost:8765/user-auth/gifs'
  },
  positive: {
    token: 'token123'
  }
};

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authenticationService: AuthenticationService;
  let positiveResponse: any;
  let spyAuthenticateUser: any;
  let spySetBearerToken: any;
  let spyRouteToDashboard: any;
  const routerSpy: any = {};
  let location: Location;
  let routerService: any;
  let errorMessage: any;
  let debugElement: any;
  let element: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[RouterTestingModule,AngularMaterialModule,HttpClientModule,
        FormsModule,BrowserAnimationsModule,
        FormsModule,
        BrowserAnimationsModule,
        HttpClientModule,
        ReactiveFormsModule ],
      declarations: [ LoginComponent ],
      providers: [
        AuthenticationService,
        RouterService,
        { provide: Location, useValue: {} },
        { provide: Router, useValue: routerSpy }
        ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    location = TestBed.get(Location);
    authenticationService = fixture.debugElement.injector.get(AuthenticationService);
    routerService = fixture.debugElement.injector.get(RouterService);
  });

  it('should create LoginComponent', () => {
    expect(component).toBeTruthy();
  });
/*
  it('should handle to login into the system', fakeAsync(() => {
    positiveResponse = testConfig.positive;
    spyAuthenticateUser = spyOn(authenticationService, 'login').and.returnValue(Observable.bind(positiveResponse));
    const token = testConfig.positive.token;
    var form: NgForm = new NgForm(null,null);
    
    spySetBearerToken = spyOn(authenticationService, 'setBearerToken').and.callFake(function(){
      localStorage.setItem('bearerToken', token);
    });
    spyRouteToDashboard = spyOn(routerService, 'routeToDashboard').and.callFake(function(){});
    const username = 'stranger';
    component.userName= username;
    const password = 'password';
    component.password = password;
    form.controls.userName.setValue(component.userName);
    form.controls.password.setValue(component.password);
    component.ng
    expect(localStorage.getItem('bearerToken')).toBe(token, 'should get token from local storage');
  }));*/
});
