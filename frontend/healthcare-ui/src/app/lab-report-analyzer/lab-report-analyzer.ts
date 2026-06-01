import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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

  constructor(private http: HttpClient) {}

  analyze(): void {

    this.loading = true;

    this.http.post(
      'http://localhost:8080/api/ai/analyze-lab',
      {
        report: this.report
      },
      {
        responseType: 'text'
      }
    ).subscribe({

      next: (response) => {

        this.result = response;

        this.loading = false;
      },

      error: () => {

        this.result = 'Failed to analyze report';

        this.loading = false;
      }
    });
  }
}