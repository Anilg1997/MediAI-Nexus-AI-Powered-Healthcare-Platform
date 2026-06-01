import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalAiAssistant } from './medical-ai-assistant';

describe('MedicalAiAssistant', () => {
  let component: MedicalAiAssistant;
  let fixture: ComponentFixture<MedicalAiAssistant>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MedicalAiAssistant],
    }).compileComponents();

    fixture = TestBed.createComponent(MedicalAiAssistant);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
