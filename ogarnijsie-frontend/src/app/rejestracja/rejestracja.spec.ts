import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Rejestracja } from './rejestracja';

describe('Rejestracja', () => {
  let component: Rejestracja;
  let fixture: ComponentFixture<Rejestracja>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Rejestracja],
    }).compileComponents();

    fixture = TestBed.createComponent(Rejestracja);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
