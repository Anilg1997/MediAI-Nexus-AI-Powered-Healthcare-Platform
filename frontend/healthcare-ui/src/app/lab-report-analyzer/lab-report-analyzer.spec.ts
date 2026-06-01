import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabReportAnalyzer } from './lab-report-analyzer';

describe('LabReportAnalyzer', () => {
  let component: LabReportAnalyzer;
  let fixture: ComponentFixture<LabReportAnalyzer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LabReportAnalyzer],
    }).compileComponents();

    fixture = TestBed.createComponent(LabReportAnalyzer);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
