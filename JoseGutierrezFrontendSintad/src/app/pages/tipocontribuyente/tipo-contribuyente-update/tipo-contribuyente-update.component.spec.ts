import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoContribuyenteUpdateComponent } from './tipo-contribuyente-update.component';

describe('TipoContribuyenteUpdateComponent', () => {
  let component: TipoContribuyenteUpdateComponent;
  let fixture: ComponentFixture<TipoContribuyenteUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TipoContribuyenteUpdateComponent]
    });
    fixture = TestBed.createComponent(TipoContribuyenteUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
