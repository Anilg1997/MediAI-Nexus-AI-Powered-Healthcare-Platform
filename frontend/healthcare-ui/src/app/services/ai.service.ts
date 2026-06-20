import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AiService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8080/api/ai';

  private agentBaseUrl =
    'http://localhost:8080/api/agent';

  analyzeSymptoms(data: any): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/symptom-check`,
      data
    );
  }

  chat(question: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/chat`,
      { question }
    );
  }

  ragChat(question: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/rag-chat`,
      { question }
    );
  }

  summarizeReport(report: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/summarize`,
      { report }
    );
  }

  analyzePrescription(prescription: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/analyze-prescription`,
      { prescription }
    );
  }

  analyzeLabReport(report: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/analyze-lab`,
      { report }
    );
  }

  medicalQA(question: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/medical-qa`,
      { question }
    );
  }

  medicalAssistant(question: string): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/medical-assistant`,
      { question }
    );
  }

  agentAsk(query: string, agenticMode: boolean = false): Observable<any> {
    return this.http.get(
      `${this.agentBaseUrl}/ask`,
      {
        params: {
          query: query,
          agenticMode: agenticMode.toString()
        }
      }
    );
  }

  agentOrchestrate(query: string): Observable<any> {
    return this.http.post(
      `${this.agentBaseUrl}/orchestrate`,
      { query }
    );
  }
}