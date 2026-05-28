import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class MedicalRecordService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8087/api/medical-records';

  addRecord(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getRecords() {

    return this.http.get(
      this.baseUrl
    );
  }

  updateRecord(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deleteRecord(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`
    );
  }
}