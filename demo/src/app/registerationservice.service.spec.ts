import { TestBed } from '@angular/core/testing';

import { RegisterationserviceService } from './registerationservice.service';

describe('RegisterationserviceService', () => {
  let service: RegisterationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
