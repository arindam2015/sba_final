import { TestBed } from '@angular/core/testing';

import { AuthenticationService } from './authentication.service';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuard } from '../auth.guard';
import { Router } from '@angular/router';
import { GipherService } from './gipher.service';
import { RouterService } from './router.service';

describe('AuthenticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({
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
  }));

  it('AuthenticationService should be created', () => {
    const service: AuthenticationService = TestBed.get(AuthenticationService);
    expect(service).toBeTruthy();
  });
});
