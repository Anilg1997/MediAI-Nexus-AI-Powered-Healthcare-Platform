import { Component } from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { HttpClient }
from '@angular/common/http';

@Component({
  selector:
    'app-medical-ai-assistant',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './medical-ai-assistant.html',

  styleUrl:
    './medical-ai-assistant.css'
})
export class MedicalAiAssistantComponent {

  question = '';

  answer = '';

  loading = false;

  constructor(
    private http: HttpClient
  ) {}

  askQuestion(): void {

    if (!this.question.trim()) {

      return;
    }

    this.loading = true;

    this.http.post(
      'http://localhost:8080/api/ai/medical-qa',
      {
        question:
          this.question
      },
      {
        responseType:
          'text'
      }
    ).subscribe({

      next: (response) => {

        this.answer =
          response;

        this.loading =
          false;
      },

      error: () => {

        this.answer =
          'Unable to get answer';

        this.loading =
          false;
      }
    });
  }
}