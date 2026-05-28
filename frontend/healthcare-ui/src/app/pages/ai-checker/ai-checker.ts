import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { AiService }
from '../../services/ai.service';

@Component({

  selector: 'app-ai-checker',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './ai-checker.html',

  styleUrl:
    './ai-checker.css'
})

export class AiCheckerComponent {

  private aiService =
    inject(AiService);

  symptoms = '';

  result: any = null;

  analyzeSymptoms() {

    this.aiService

      .analyzeSymptoms({

        symptoms:
          this.symptoms

      })

      .subscribe({

        next: (response) => {

          this.result =
            response;
        }
      });
  }
}