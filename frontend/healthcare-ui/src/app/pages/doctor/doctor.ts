import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { DoctorService }
from '../../services/doctor.service';

@Component({

  selector: 'app-doctor',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './doctor.html',

  styleUrl:
    './doctor.css'
})

export class DoctorComponent {

  private doctorService =
    inject(DoctorService);

  doctors: any[] = [];

  editMode = false;

  selectedDoctorId = 0;

  doctor = {

    name: '',

    specialization: '',

    experience: '',

    email: '',

    available: true
  };

  ngOnInit() {

    this.loadDoctors();
  }

  addDoctor() {

    if (this.editMode) {

      this.updateDoctor();

      return;
    }

    this.doctorService

      .addDoctor(this.doctor)

      .subscribe({

        next: () => {

          alert(
            'Doctor Added');

          this.loadDoctors();

          this.resetForm();
        }
      });
  }

  loadDoctors() {

    this.doctorService

      .getDoctors()

      .subscribe({

        next: (data: any) => {

          this.doctors = data;
        }
      });
  }

  editDoctor(doctor: any) {

    this.editMode = true;

    this.selectedDoctorId =
      doctor.id;

    this.doctor = { ...doctor };
  }

  updateDoctor() {

    this.doctorService

      .updateDoctor(

        this.selectedDoctorId,

        this.doctor

      )

      .subscribe({

        next: () => {

          alert(
            'Doctor Updated');

          this.loadDoctors();

          this.resetForm();
        }
      });
  }

  deleteDoctor(id: number) {

    this.doctorService

      .deleteDoctor(id)

      .subscribe({

        next: () => {

          alert(
            'Doctor Deleted');

          this.loadDoctors();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedDoctorId = 0;

    this.doctor = {

      name: '',

      specialization: '',

      experience: '',

      email: '',

      available: true
    };
  }
}