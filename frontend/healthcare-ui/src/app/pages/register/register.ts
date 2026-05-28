import { Component, inject } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { Router, RouterLink }
from '@angular/router';

import { CommonModule }
from '@angular/common';

import { AuthService }
from '../../services/auth';

@Component({
  selector: 'app-register',
  standalone: true,

  imports: [
    FormsModule,
    RouterLink,
    CommonModule
  ],

  templateUrl: './register.html',

  styleUrl: './register.css'
})

export class RegisterComponent {

  private authService =
    inject(AuthService);

  private router =
    inject(Router);

  username = '';

  email = '';

  password = '';

  successMessage = '';

  errorMessage = '';

  loading = false;

  register() {

    this.loading = true;

    this.successMessage = '';

    this.errorMessage = '';

    const data = {

      username: this.username,

      email: this.email,

      password: this.password
    };

    this.authService
      .register(data)
      .subscribe({

        next: () => {

          this.loading = false;

          this.successMessage =
            'Registration Successful';

          setTimeout(() => {

            this.router.navigate(['/']);

          }, 2000);
        },

        error: (error) => {

          this.loading = false;

          console.log(error);

          this.errorMessage =
            'Registration Failed';
        }
      });
  }
}