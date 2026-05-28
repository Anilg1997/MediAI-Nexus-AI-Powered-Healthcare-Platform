import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { PrescriptionService }
from '../../services/prescription.service';

@Component({

  selector: 'app-prescription',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './prescription.html',

  styleUrl:
    './prescription.css'
})

export class PrescriptionComponent {

  private prescriptionService =
    inject(PrescriptionService);

  prescriptions: any[] = [];

  editMode = false;

  selectedPrescriptionId = 0;

  prescription = {

    appointmentId: '',

    patientId: '',

    doctorId: '',

    medicines: '',

    dosage: '',

    instructions: '',

    createdDate: ''
  };

  ngOnInit() {

    this.loadPrescriptions();
  }

  addPrescription() {

    if (this.editMode) {

      this.updatePrescription();

      return;
    }

    this.prescriptionService

      .addPrescription(this.prescription)

      .subscribe({

        next: () => {

          alert(
            'Prescription Added');

          this.loadPrescriptions();

          this.resetForm();
        }
      });
  }

  loadPrescriptions() {

    this.prescriptionService

      .getPrescriptions()

      .subscribe({

        next: (data: any) => {

          this.prescriptions = data;
        }
      });
  }

  editPrescription(
      prescription: any) {

    this.editMode = true;

    this.selectedPrescriptionId =
      prescription.id;

    this.prescription = {
      ...prescription
    };
  }

  updatePrescription() {

    this.prescriptionService

      .updatePrescription(

        this.selectedPrescriptionId,

        this.prescription

      )

      .subscribe({

        next: () => {

          alert(
            'Prescription Updated');

          this.loadPrescriptions();

          this.resetForm();
        }
      });
  }

  deletePrescription(
      id: number) {

    this.prescriptionService

      .deletePrescription(id)

      .subscribe({

        next: () => {

          alert(
            'Prescription Deleted');

          this.loadPrescriptions();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedPrescriptionId = 0;

    this.prescription = {

      appointmentId: '',

      patientId: '',

      doctorId: '',

      medicines: '',

      dosage: '',

      instructions: '',

      createdDate: ''
    };
  }
}