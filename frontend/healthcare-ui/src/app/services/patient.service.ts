import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PatientService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8082/api/patients';

  addPatient(data: any) {

    return this.http.post(
      this.baseUrl,
      data
    );
  }

  getPatients() {

    return this.http.get(
      this.baseUrl
    );
  }

  deletePatient(id: number) {

    return this.http.delete(

      `${this.baseUrl}/${id}`

    );
  }
  
updatePatient(
  id: number,
  data: any) {

  return this.http.put(

    `${this.baseUrl}/${id}`,

    data
  );
}
}