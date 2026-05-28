import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AiChecker } from './ai-checker';

describe('AiChecker', () => {
  let component: AiChecker;
  let fixture: ComponentFixture<AiChecker>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AiChecker],
    }).compileComponents();

    fixture = TestBed.createComponent(AiChecker);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
