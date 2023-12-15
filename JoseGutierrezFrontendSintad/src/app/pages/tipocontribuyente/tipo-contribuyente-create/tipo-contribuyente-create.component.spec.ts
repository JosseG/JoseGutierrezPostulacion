import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoContribuyenteCreateComponent } from './tipo-contribuyente-create.component';

describe('TipoContribuyenteCreateComponent', () => {
  let component: TipoContribuyenteCreateComponent;
  let fixture: ComponentFixture<TipoContribuyenteCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TipoContribuyenteCreateComponent]
    });
    fixture = TestBed.createComponent(TipoContribuyenteCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
