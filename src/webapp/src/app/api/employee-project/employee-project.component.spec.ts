import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeProjectComponent } from './employee-project.component';

describe('EmployeeProjectComponent', () => {
  let component: EmployeeProjectComponent;
  let fixture: ComponentFixture<EmployeeProjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeProjectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
