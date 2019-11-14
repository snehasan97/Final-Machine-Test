import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvendorsComponent } from './addvendors.component';

describe('AddvendorsComponent', () => {
  let component: AddvendorsComponent;
  let fixture: ComponentFixture<AddvendorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddvendorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddvendorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
