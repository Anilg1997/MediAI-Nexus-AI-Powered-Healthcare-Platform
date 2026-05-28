import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { MedicalRecordService }
from '../../services/medical-record.service';

@Component({

  selector: 'app-medical-record',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './medical-record.html',

  styleUrl:
    './medical-record.css'
})

export class MedicalRecordComponent {

  private medicalRecordService =
    inject(MedicalRecordService);

  records: any[] = [];

  editMode = false;

  selectedRecordId = 0;

  record = {

    patientId: '',

    doctorId: '',

    diagnosis: '',

    testResults: '',

    doctorNotes: '',

    visitDate: ''
  };

  ngOnInit() {

    this.loadRecords();
  }

  addRecord() {

    if (this.editMode) {

      this.updateRecord();

      return;
    }

    this.medicalRecordService

      .addRecord(this.record)

      .subscribe({

        next: () => {

          alert(
            'Medical Record Added');

          this.loadRecords();

          this.resetForm();
        }
      });
  }

  loadRecords() {

    this.medicalRecordService

      .getRecords()

      .subscribe({

        next: (data: any) => {

          this.records = data;
        }
      });
  }

  editRecord(record: any) {

    this.editMode = true;

    this.selectedRecordId =
      record.id;

    this.record = {
      ...record
    };
  }

  updateRecord() {

    this.medicalRecordService

      .updateRecord(

        this.selectedRecordId,

        this.record

      )

      .subscribe({

        next: () => {

          alert(
            'Medical Record Updated');

          this.loadRecords();

          this.resetForm();
        }
      });
  }

  deleteRecord(id: number) {

    this.medicalRecordService

      .deleteRecord(id)

      .subscribe({

        next: () => {

          alert(
            'Medical Record Deleted');

          this.loadRecords();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedRecordId = 0;

    this.record = {

      patientId: '',

      doctorId: '',

      diagnosis: '',

      testResults: '',

      doctorNotes: '',

      visitDate: ''
    };
  }
}