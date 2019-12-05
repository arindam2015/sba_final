import { TestBed, async, inject, fakeAsync } from '@angular/core/testing';

import { AuthGuard } from './auth.guard';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './services/authentication.service';
import { GipherService } from './services/gipher.service';
import { RouterService } from './services/router.service';

describe('AuthGuard', () => {
  let canActivateRouteGuard: AuthGuard;
  const activatedRouteSnapshot: ActivatedRouteSnapshot = new ActivatedRouteSnapshot();
  const routerStateSnapshot: RouterStateSnapshot = jasmine.createSpyObj<RouterStateSnapshot>('RouterStateSnapshot', ['toString']);
  let authService: any;
  let spyCanActivate: any;
  let response: any;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule
        ],
      providers: [
        AuthGuard,
        { provide: Location, useValue: {back: () => { }} },
        { provide: Router, useValue: {} },
        AuthenticationService,
        GipherService,
        RouterService
      ]
    });
    canActivateRouteGuard=TestBed.get(AuthGuard);
    authService=TestBed.get(AuthenticationService);
  });

  it('should create route guard service', inject([AuthGuard], (guard: AuthGuard) => {
    expect(guard).toBeTruthy();
  }));
  // ------------ Positive testing of isUserAuthenticated------------//
  it('should handle to know if user is aunthenticated', fakeAsync(() => {
    spyCanActivate = spyOn(canActivateRouteGuard, 'canActivate').and.callFake( function() { return true; } );
    response = canActivateRouteGuard.canActivate(activatedRouteSnapshot, routerStateSnapshot);
    expect(response).toBe(true, 'user is authenticated');
  }));

   // ------------ Positive testing of isUserAuthenticated------------//
  it('should handle to know if user is not aunthenticated', fakeAsync(() => {
    spyCanActivate = spyOn(canActivateRouteGuard, 'canActivate').and.callFake( function() { return false; } );
    response = canActivateRouteGuard.canActivate(activatedRouteSnapshot, routerStateSnapshot);
    expect(response).toBe(false, 'user is not authenticated');
  }));
});
