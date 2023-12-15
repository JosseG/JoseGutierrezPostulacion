import { TestBed } from '@angular/core/testing';

import { MyCustomInterceptor } from './my-custom.interceptor';

describe('MyCustomInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      MyCustomInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: MyCustomInterceptor = TestBed.inject(MyCustomInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
