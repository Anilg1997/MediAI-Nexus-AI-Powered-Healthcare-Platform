import {
  Component,
  inject,
  OnInit
}
from '@angular/core';

import { Router }
from '@angular/router';

import { AuthService }
from '../../services/auth';

@Component({
  selector: 'app-dashboard',

  standalone: true,

  imports: [],

  templateUrl: './dashboard.html',

  styleUrl: './dashboard.css'
})

export class DashboardComponent
implements OnInit {

  private router =
    inject(Router);

  private authService =
    inject(AuthService);

  profileMessage = '';

  ngOnInit(): void {

    this.loadProfile();
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

    this.router.navigate(['/']);
  }
}