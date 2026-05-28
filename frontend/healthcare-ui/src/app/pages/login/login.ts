import { Component, inject } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { Router, RouterLink }
from '@angular/router';

import { CommonModule }
from '@angular/common';

import { AuthService }
from '../../services/auth';

@Component({
  selector: 'app-login',

  standalone: true,

  imports: [
    FormsModule,
    RouterLink,
    CommonModule
  ],

  templateUrl: './login.html',

  styleUrl: './login.css'
})

export class LoginComponent {

  private authService =
    inject(AuthService);

  private router =
    inject(Router);

  email = '';

  password = '';

  successMessage = '';

  errorMessage = '';

  loading = false;

  login() {

    this.loading = true;

    this.successMessage = '';

    this.errorMessage = '';

    const data = {

      email: this.email,

      password: this.password
    };

    this.authService
      .login(data)
      .subscribe({

        next: (token) => {

          this.loading = false;

          localStorage.setItem(
            'token',
            token
          );

          this.successMessage =
            'Login Successful';

          setTimeout(() => {

            this.router.navigate([
              '/dashboard'
            ]);

          }, 1000);
        },

        error: (error) => {

          this.loading = false;

          console.log(error);

          this.errorMessage =
            'Invalid Email or Password';
        }
      });
  }
}