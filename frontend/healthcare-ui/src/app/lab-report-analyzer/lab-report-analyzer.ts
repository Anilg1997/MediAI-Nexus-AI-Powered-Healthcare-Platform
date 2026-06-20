import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { AiService } from '../services/ai.service';

@Component({
  selector: 'app-lab-report-analyzer',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './lab-report-analyzer.html',
  styleUrl: './lab-report-analyzer.css'
})
export class LabReportAnalyzerComponent {

  report = '';
  result = '';
  loading = false;
  error = '';

  private aiService = inject(AiService);

  analyze(): void {
    if (!this.report.trim()) {
      this.error = 'Please enter lab report details';
      return;
    }

    this.loading = true;
    this.error = '';
    this.result = '';

    this.aiService.analyzeLabReport(this.report)
      .subscribe({
        next: (response) => {
          this.result = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = 'Failed to analyze lab report. Please try again.';
          this.loading = false;
        }
      });
  }

  clearResult() {
    this.result = '';
    this.error = '';
    this.report = '';
  }
}