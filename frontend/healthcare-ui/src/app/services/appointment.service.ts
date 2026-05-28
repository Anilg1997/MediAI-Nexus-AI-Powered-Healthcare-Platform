import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AppointmentService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8084/api/appointments';

  addAppointment(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getAppointments() {

    return this.http.get(
      this.baseUrl
    );
  }

  updateAppointment(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deleteAppointment(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`

    );
  }
}