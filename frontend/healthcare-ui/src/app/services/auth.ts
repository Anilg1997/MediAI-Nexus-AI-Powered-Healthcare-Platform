import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private http = inject(HttpClient);

  private baseUrl =
    'http://localhost:8081/api/auth';
    getProfile() {

  return this.http.get(
    `${this.baseUrl}/profile`,
    {
      responseType: 'text'
    }
  );
}

  register(data: any) {

  return this.http.post(
    `${this.baseUrl}/register`,
    data,
    {
      responseType: 'text'
    }
  );
}

  login(data: any) {

    return this.http.post(
      `${this.baseUrl}/login`,
      data,
      {
        responseType: 'text'
      }
    );
  }
}