import { Component }
from '@angular/core';

import {
  Router,
  RouterLink,
  NavigationEnd
}
from '@angular/router';

import { CommonModule }
from '@angular/common';

import { filter }
from 'rxjs';

@Component({

  selector: 'app-navbar',

  standalone: true,

  imports: [
    RouterLink,
    CommonModule
  ],

  templateUrl:
    './navbar.html',

  styleUrl:
    './navbar.css'
})

export class NavbarComponent {

  showNavbar = true;

  constructor(
      private router: Router) {

    this.router.events

      .pipe(

        filter(event =>
          event instanceof NavigationEnd)

      )

      .subscribe(() => {

        const hiddenRoutes = [

          '/',

          '/register'
        ];

        this.showNavbar =

          !hiddenRoutes.includes(

            this.router.url
          );
      });
  }

  logout() {

    localStorage.removeItem(
      'token');

    window.location.href = '/';
  }
}