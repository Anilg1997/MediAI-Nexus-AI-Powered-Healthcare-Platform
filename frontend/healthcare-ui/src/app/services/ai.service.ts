import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AiService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8085/api/ai';

  analyzeSymptoms(data: any) {

    return this.http.post(

      `${this.baseUrl}/analyze`,

      data
    );
  }
}