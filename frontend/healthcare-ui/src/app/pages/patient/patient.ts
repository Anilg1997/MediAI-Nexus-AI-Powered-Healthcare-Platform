import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { PatientService }
from '../../services/patient.service';

@Component({

  selector: 'app-patient',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './patient.html',

  styleUrl:
    './patient.css'
})

export class PatientComponent {

  private patientService =
    inject(PatientService);

  patients: any[] = [];

  editMode = false;

  selectedPatientId = 0;

  patient = {

    name: '',

    age: '',

    disease: '',

    email: ''
  };

  ngOnInit() {

    this.loadPatients();
  }

  addPatient() {

    if (this.editMode) {

      this.updatePatient();

      return;
    }

    this.patientService

      .addPatient(this.patient)

      .subscribe({

        next: () => {

          alert(
            'Patient Added');

          this.loadPatients();

          this.resetForm();
        }
      });
  }

  loadPatients() {

    this.patientService

      .getPatients()

      .subscribe({

        next: (data: any) => {

          this.patients = data;
        }
      });
  }

  editPatient(patient: any) {

    this.editMode = true;

    this.selectedPatientId =
      patient.id;

    this.patient = { ...patient };
  }

  updatePatient() {

    this.patientService

      .updatePatient(

        this.selectedPatientId,

        this.patient

      )

      .subscribe({

        next: () => {

          alert(
            'Patient Updated');

          this.loadPatients();

          this.resetForm();
        }
      });
  }

  deletePatient(id: number) {

    this.patientService

      .deletePatient(id)

      .subscribe({

        next: () => {

          alert(
            'Patient Deleted');

          this.loadPatients();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedPatientId = 0;

    this.patient = {

      name: '',

      age: '',

      disease: '',

      email: ''
    };
  }
}