import { Component, inject }
from '@angular/core';

import { CommonModule }
from '@angular/common';

import { FormsModule }
from '@angular/forms';

import { PaymentService }
from '../../services/payment.service';

@Component({

  selector: 'app-payment',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl:
    './payment.html',

  styleUrl:
    './payment.css'
})

export class PaymentComponent {

  private paymentService =
    inject(PaymentService);

  payments: any[] = [];

  editMode = false;

  selectedPaymentId = 0;

  payment = {

    patientId: '',

    appointmentId: '',

    amount: '',

    paymentMethod: '',

    paymentStatus: '',

    transactionId: '',

    paymentDate: ''
  };

  ngOnInit() {

    this.loadPayments();
  }

  addPayment() {

    if (this.editMode) {

      this.updatePayment();

      return;
    }

    this.paymentService

      .addPayment(this.payment)

      .subscribe({

        next: () => {

          alert(
            'Payment Added');

          this.loadPayments();

          this.resetForm();
        }
      });
  }

  loadPayments() {

    this.paymentService

      .getPayments()

      .subscribe({

        next: (data: any) => {

          this.payments = data;
        }
      });
  }

  editPayment(payment: any) {

    this.editMode = true;

    this.selectedPaymentId =
      payment.id;

    this.payment = {
      ...payment
    };
  }

  updatePayment() {

    this.paymentService

      .updatePayment(

        this.selectedPaymentId,

        this.payment

      )

      .subscribe({

        next: () => {

          alert(
            'Payment Updated');

          this.loadPayments();

          this.resetForm();
        }
      });
  }

  deletePayment(id: number) {

    this.paymentService

      .deletePayment(id)

      .subscribe({

        next: () => {

          alert(
            'Payment Deleted');

          this.loadPayments();
        }
      });
  }

  resetForm() {

    this.editMode = false;

    this.selectedPaymentId = 0;

    this.payment = {

      patientId: '',

      appointmentId: '',

      amount: '',

      paymentMethod: '',

      paymentStatus: '',

      transactionId: '',

      paymentDate: ''
    };
  }
}