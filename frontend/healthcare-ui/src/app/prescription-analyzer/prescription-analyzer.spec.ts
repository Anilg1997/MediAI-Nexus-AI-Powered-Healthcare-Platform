import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptionAnalyzer } from './prescription-analyzer';

describe('PrescriptionAnalyzer', () => {
  let component: PrescriptionAnalyzer;
  let fixture: ComponentFixture<PrescriptionAnalyzer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrescriptionAnalyzer],
    }).compileComponents();

    fixture = TestBed.createComponent(PrescriptionAnalyzer);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
