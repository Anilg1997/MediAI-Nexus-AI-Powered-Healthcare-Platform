import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { FileService }
from '../../services/file.service';

@Component({

  selector: 'app-files',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './files.html',

  styleUrl:
    './files.css'
})

export class FilesComponent {

  private fileService =
    inject(FileService);

  patientId = '';

  selectedFile!: File;

  files: any[] = [];

  ngOnInit() {

    this.loadFiles();
  }

  onFileSelected(event: any) {

    this.selectedFile =
      event.target.files[0];
  }

  uploadFile() {

    if (!this.selectedFile) {

      alert('Select a file');

      return;
    }

    this.fileService

      .uploadFile(

        Number(this.patientId),

        this.selectedFile

      )

      .subscribe({

        next: () => {

          alert(
            'File Uploaded Successfully');

          this.loadFiles();

          this.patientId = '';
        }
      });
  }

  loadFiles() {

    this.fileService

      .getFiles()

      .subscribe({

        next: (data: any) => {

          this.files = data;
        }
      });
  }
}