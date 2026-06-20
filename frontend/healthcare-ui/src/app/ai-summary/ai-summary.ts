import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { AiService } from '../services/ai.service';

@Component({
  selector: 'app-ai-summary',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './ai-summary.html',
  styleUrl: './ai-summary.css'
})
export class AiSummaryComponent {

  report = '';
  summary = '';
  loading = false;
  error = '';

  private aiService = inject(AiService);

  summarize(): void {
    if (!this.report.trim()) {
      this.error = 'Please enter a report to summarize';
      return;
    }

    this.loading = true;
    this.error = '';
    this.summary = '';

    this.aiService.summarizeReport(this.report)
      .subscribe({
        next: (response) => {
          this.summary = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = 'Failed to summarize report. Please try again.';
          this.loading = false;
        }
      });
  }

  clearSummary() {
    this.summary = '';
    this.error = '';
    this.report = '';
  }
}