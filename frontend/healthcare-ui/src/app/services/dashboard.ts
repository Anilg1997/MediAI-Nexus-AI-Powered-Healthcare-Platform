import { Injectable } from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(
    private http: HttpClient
  ) {}

  getStats() {

    return this.http.get<any>(
      'http://localhost:8080/api/dashboard/stats'
    );
  }
}