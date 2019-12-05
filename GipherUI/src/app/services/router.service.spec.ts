import { TestBed } from '@angular/core/testing';

import { RouterService } from './router.service';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuard } from '../auth.guard';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { GipherService } from './gipher.service';

describe('RouterService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientModule,HttpModule
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

  it('RouterService should be created', () => {
    const service: RouterService = TestBed.get(RouterService);
    expect(service).toBeTruthy();
  });
});
