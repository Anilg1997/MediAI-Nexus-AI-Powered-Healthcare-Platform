import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { AiService } from '../services/ai.service';

@Component({
  selector: 'app-medical-ai-assistant',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl: './medical-ai-assistant.html',

  styleUrl: './medical-ai-assistant.css'
})
export class MedicalAiAssistantComponent {

  question = '';

  answer = '';

  loading = false;

  agenticMode = false;

  conversationHistory: { role: 'user' | 'assistant', content: string }[] = [];

  private aiService = inject(AiService);

  askQuestion(): void {
    if (!this.question.trim()) {
      return;
    }

    this.loading = true;

    const payload = {
      query: this.question,
      agenticMode: this.agenticMode
    };

    this.aiService.agentAsk(this.question, this.agenticMode)
      .subscribe({
        next: (response) => {
          this.answer = response;
          this.conversationHistory.push(
            { role: 'user', content: this.question },
            { role: 'assistant', content: response }
          );
          this.loading = false;
          this.question = '';
        },
        error: () => {
          this.answer = 'Unable to get answer';
          this.loading = false;
        }
      });
  }

  clearConversation(): void {
    this.conversationHistory = [];
    this.answer = '';
  }

  toggleAgenticMode(): void {
    this.agenticMode = !this.agenticMode;
    this.clearConversation();
  }
}