import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
selector: 'app-navbar',
standalone: true,
imports: [
CommonModule,
RouterLink
],
templateUrl: './navbar.html',
styleUrl: './navbar.css'
})
export class NavbarComponent {

showAiMenu = false;
showUserMenu = false;

constructor(
private router: Router
) {}

get isLoggedIn(): boolean {


return !!localStorage.getItem('token');


}

get username(): string {


return localStorage.getItem('username') || '';


}

toggleAiMenu(): void {


this.showAiMenu = !this.showAiMenu;


}

logout(): void {

  localStorage.clear();

  this.router.navigate([
    '/login'
  ]);



}
}
