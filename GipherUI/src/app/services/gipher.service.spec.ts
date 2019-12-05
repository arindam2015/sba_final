import { TestBed } from '@angular/core/testing';

import { GipherService } from './gipher.service';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuard } from '../auth.guard';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { RouterService } from './router.service';
import { HttpModule } from '@angular/http';

describe('GipherService', () => {
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

  it('GipherService should be created', () => {
    const service: GipherService = TestBed.get(GipherService);
    expect(service).toBeTruthy();
  });
});
