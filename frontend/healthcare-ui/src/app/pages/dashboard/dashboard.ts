import {
Component,
inject,
OnInit,
AfterViewInit
}
from '@angular/core';

import { DashboardService }
from '../../services/dashboard';

import { Router }
from '@angular/router';

import { AuthService }
from '../../services/auth';

import Chart
from 'chart.js/auto';

@Component({

selector: 'app-dashboard',

standalone: true,

imports: [],

templateUrl: './dashboard.html',

styleUrl: './dashboard.css'
})

export class DashboardComponent
implements OnInit, AfterViewInit {
stats: any;

private router =
inject(Router);
  
private authService =
inject(AuthService);

private dashboardService =
  inject(DashboardService);
profileMessage = '';

ngOnInit(): void {

  this.loadProfile();

  this.dashboardService
    .getStats()
    .subscribe(data => {

      this.stats = data;
    });
}
ngAfterViewInit(): void {


new Chart(
  'patientsChart',
  {

    type: 'bar',

    data: {

      labels: [
        'Jan',
        'Feb',
        'Mar',
        'Apr',
        'May'
      ],

      datasets: [{

        label: 'Patients',

        data: [
          50,
          80,
          95,
          110,
          120
        ]
      }]
    }
  }
);

new Chart(
  'appointmentsChart',
  {

    type: 'line',

    data: {

      labels: [
        'Mon',
        'Tue',
        'Wed',
        'Thu',
        'Fri'
      ],

      datasets: [{

        label: 'Appointments',

        data: [
          10,
          15,
          20,
          25,
          30
        ]
      }]
    }
  }
);

new Chart(
  'revenueChart',
  {

    type: 'doughnut',

    data: {

      labels: [
        'Completed',
        'Pending'
      ],

      datasets: [{

        data: [
          50000,
          12000
        ]
      }]
    }
  }
);


}

loadProfile() {


this.authService
  .getProfile()
  .subscribe({

    next: (response) => {

      this.profileMessage =
        response;
    },

    error: (error) => {

      console.log(error);
    }
  });


}

logout() {


localStorage.removeItem(
  'token'
);

this.router.navigate([
  '/'
]);


}
}
