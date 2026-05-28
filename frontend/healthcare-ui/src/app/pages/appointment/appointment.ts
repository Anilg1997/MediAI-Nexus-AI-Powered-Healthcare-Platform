import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { AppointmentService }
from '../../services/appointment.service';

@Component({

  selector: 'app-appointment',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './appointment.html',

  styleUrl:
    './appointment.css'
})

export class AppointmentComponent {

  private appointmentService =
    inject(AppointmentService);

  appointments: any[] = [];

  appointment = {

    patientId: '',

    doctorId: '',

    appointmentDate: '',

    reason: ''
  };

  ngOnInit() {

    this.loadAppointments();
  }

  addAppointment() {

    this.appointmentService

      .addAppointment(this.appointment)

      .subscribe({

        next: () => {

          alert(
            'Appointment Booked');

          this.loadAppointments();
        }
      });
  }

  loadAppointments() {

    this.appointmentService

      .getAppointments()

      .subscribe({

        next: (data: any) => {

          this.appointments = data;
        }
      });
  }

  deleteAppointment(id: number) {

    this.appointmentService

      .deleteAppointment(id)

      .subscribe({

        next: () => {

          alert(
            'Appointment Deleted');

          this.loadAppointments();
        }
      });
  }
}