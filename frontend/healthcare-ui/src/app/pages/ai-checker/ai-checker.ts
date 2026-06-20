import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { AiService } from '../../services/ai.service';

@Component({
  selector: 'app-ai-checker',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl: './ai-checker.html',

  styleUrl: './ai-checker.css'
})

export class AiCheckerComponent {

  private aiService =
    inject(AiService);

  symptoms = '';

  result: any = null;

  loading = false;

  error = '';

  analyzeSymptoms() {
    if (!this.symptoms.trim()) {
      this.error = 'Please enter symptoms';
      return;
    }

    this.loading = true;
    this.error = '';
    this.result = null;

    this.aiService.analyzeSymptoms({ symptoms: this.symptoms })
      .subscribe({
        next: (response) => {
          this.result = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = 'Failed to analyze symptoms. Please try again.';
          this.loading = false;
        }
      });
  }

  clearResult() {
    this.result = null;
    this.error = '';
    this.symptoms = '';
  }
}