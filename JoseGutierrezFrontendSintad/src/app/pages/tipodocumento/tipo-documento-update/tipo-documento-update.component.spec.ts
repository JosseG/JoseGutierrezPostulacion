import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoDocumentoUpdateComponent } from './tipo-documento-update.component';

describe('TipoDocumentoUpdateComponent', () => {
  let component: TipoDocumentoUpdateComponent;
  let fixture: ComponentFixture<TipoDocumentoUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TipoDocumentoUpdateComponent]
    });
    fixture = TestBed.createComponent(TipoDocumentoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
