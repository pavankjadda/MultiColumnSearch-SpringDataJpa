import { TestBed } from '@angular/core/testing';

import { EmployeeProjectService } from './employee-project.service';

describe('EmployeeProjectService', () => {
  let service: EmployeeProjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeProjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
