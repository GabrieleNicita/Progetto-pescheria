import { TestBed } from '@angular/core/testing';

import { TrattamentoService } from './trattamento.service';

describe('TrattamentoService', () => {
  let service: TrattamentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrattamentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
