import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class LabService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8088/api/labs';

  addLabReport(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getLabReports() {

    return this.http.get(
      this.baseUrl
    );
  }

  updateLabReport(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deleteLabReport(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`
    );
  }
}