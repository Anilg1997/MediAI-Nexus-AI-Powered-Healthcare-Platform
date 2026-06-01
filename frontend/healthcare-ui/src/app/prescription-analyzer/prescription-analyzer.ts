import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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

  constructor(
    private http: HttpClient
  ) {}

  analyze(): void {

    if (!this.prescription.trim()) {

      alert('Please enter prescription details');

      return;
    }

    this.loading = true;

    this.http.post(
      'http://localhost:8080/api/ai/analyze-prescription',
      {
        prescription: this.prescription
      },
      {
        responseType: 'text'
      }
    ).subscribe({

      next: (response) => {

        this.result = response;

        this.loading = false;
      },

      error: (error) => {

        console.error(error);

        this.result = 'Failed to analyze prescription';

        this.loading = false;
      }
    });
  }
}