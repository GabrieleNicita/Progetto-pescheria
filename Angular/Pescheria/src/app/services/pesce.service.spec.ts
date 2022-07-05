import { TestBed } from '@angular/core/testing';

import { PesceService } from './pesce.service';

describe('PesceService', () => {
  let service: PesceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PesceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
