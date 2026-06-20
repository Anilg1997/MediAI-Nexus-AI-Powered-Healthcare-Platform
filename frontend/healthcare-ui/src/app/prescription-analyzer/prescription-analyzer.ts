import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { AiService } from '../services/ai.service';

@Component({
  selector: 'app-prescription-analyzer',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './prescription-analyzer.html',
  styleUrl: './prescription-analyzer.css'
})
export class PrescriptionAnalyzerComponent {

  prescription = '';

  result = '';

  loading = false;

  error = '';

  private aiService = inject(AiService);

  analyze(): void {
    if (!this.prescription.trim()) {
      this.error = 'Please enter prescription details';
      return;
    }

    this.loading = true;
    this.error = '';
    this.result = '';

    this.aiService.analyzePrescription(this.prescription)
      .subscribe({
        next: (response) => {
          this.result = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = 'Failed to analyze prescription. Please try again.';
          this.loading = false;
        }
      });
  }

  clearResult() {
    this.result = '';
    this.error = '';
    this.prescription = '';
  }
}