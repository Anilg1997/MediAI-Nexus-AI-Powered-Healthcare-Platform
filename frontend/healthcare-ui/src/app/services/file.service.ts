import { Injectable, inject }
from '@angular/core';

import { HttpClient }
from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class FileService {

  private http =
    inject(HttpClient);

  private baseUrl =
    'http://localhost:8090/api/files';

  uploadFile(
      patientId: number,
      file: File) {

    const formData =
      new FormData();

    formData.append(
      'patientId',

      patientId.toString()
    );

    formData.append(
      'file',

      file
    );

    return this.http.post(

      `${this.baseUrl}/upload`,

      formData
    );
  }

  getFiles() {

    return this.http.get(
      this.baseUrl
    );
  }
}