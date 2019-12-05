import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommandComponent } from './recommand.component';
import { AngularMaterialModule } from '../angular-material.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpModule } from '@angular/http';

describe('RecommandComponent', () => {
  let component: RecommandComponent;
  let fixture: ComponentFixture<RecommandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [AngularMaterialModule,FormsModule,HttpClientModule,RouterTestingModule,BrowserAnimationsModule,HttpModule],
      declarations: [ RecommandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
