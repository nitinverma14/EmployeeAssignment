import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { HttpClientService } from './httpclient.service';

describe('HttpclientService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports:[HttpClientTestingModule]}));

  it('should be created', () => {
    const service: HttpClientService = TestBed.get(HttpClientService);
    expect(service).toBeTruthy();
  });
});
