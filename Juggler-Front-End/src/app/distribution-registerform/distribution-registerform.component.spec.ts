import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistributionRegisterformComponent } from './distribution-registerform.component';

describe('DistributionRegisterformComponent', () => {
  let component: DistributionRegisterformComponent;
  let fixture: ComponentFixture<DistributionRegisterformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistributionRegisterformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistributionRegisterformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
