import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookmarkComponent } from './bookmark.component';
import { AngularMaterialModule } from '../angular-material.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
import { AuthGuard } from '../auth.guard';
import { GipherService } from '../services/gipher.service';
import { HttpModule } from '@angular/http';

describe('BookmarkComponent', () => {
  let component: BookmarkComponent;
  let fixture: ComponentFixture<BookmarkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [AngularMaterialModule,FormsModule,HttpClientModule,RouterTestingModule,BrowserAnimationsModule,HttpModule],
      declarations: [ BookmarkComponent ],
      providers: [AuthenticationService,RouterService,AuthGuard,GipherService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookmarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create BookmarkComponent', () => {
    expect(component).toBeTruthy();
  });
});
