import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { AuthGaurdService } from './auth-gaurd.service';

describe('AuthGaurdService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports:[HttpClientTestingModule,RouterTestingModule]}));

  it('should be created', () => {
    const service: AuthGaurdService = TestBed.get(AuthGaurdService);
    expect(service).toBeTruthy();
  });
});
