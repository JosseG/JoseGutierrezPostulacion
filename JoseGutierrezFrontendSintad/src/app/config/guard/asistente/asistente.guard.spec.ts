import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { asistenteGuard } from './asistente.guard';

describe('asistenteGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => asistenteGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
