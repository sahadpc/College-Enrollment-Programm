import { TestBed } from '@angular/core/testing';

import { UserdashboardserviceService } from './userdashboardservice.service';

describe('UserdashboardserviceService', () => {
  let service: UserdashboardserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserdashboardserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
