import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class DoctorService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8083/api/doctors';

  addDoctor(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getDoctors() {

    return this.http.get(
      this.baseUrl
    );
  }

  updateDoctor(
      id: number,
      data: any) {

    return this.http.put(

      `${this.baseUrl}/${id}`,

      data
    );
  }

  deleteDoctor(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`

    );
  }
}