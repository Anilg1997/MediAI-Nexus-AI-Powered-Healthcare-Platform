import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PrescriptionService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8086/api/prescriptions';

  addPrescription(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getPrescriptions() {

    return this.http.get(
      this.baseUrl
    );
  }

  updatePrescription(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deletePrescription(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`
    );
  }
}