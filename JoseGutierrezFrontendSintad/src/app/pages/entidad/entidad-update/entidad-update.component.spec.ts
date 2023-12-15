import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntidadUpdateComponent } from './entidad-update.component';

describe('EntidadUpdateComponent', () => {
  let component: EntidadUpdateComponent;
  let fixture: ComponentFixture<EntidadUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntidadUpdateComponent]
    });
    fixture = TestBed.createComponent(EntidadUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
