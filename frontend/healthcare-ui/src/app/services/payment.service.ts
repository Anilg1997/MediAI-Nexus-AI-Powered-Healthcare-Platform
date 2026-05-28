import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PaymentService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8091/api/payments';

  addPayment(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getPayments() {

    return this.http.get(
      this.baseUrl
    );
  }

  updatePayment(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deletePayment(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`
    );
  }
}