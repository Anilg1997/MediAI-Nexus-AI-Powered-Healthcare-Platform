import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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

  constructor(
    private http: HttpClient
  ) {}

  summarize(): void {

    this.loading = true;

    this.http.post(
      'http://localhost:8080/api/ai/summarize',
      {
        report: this.report
      },
      {
        responseType: 'text'
      }
    ).subscribe({

      next: (response) => {

        this.summary = response;

        this.loading = false;
      },

      error: (error) => {

        console.error(error);

        this.loading = false;
      }
    });
  }
}