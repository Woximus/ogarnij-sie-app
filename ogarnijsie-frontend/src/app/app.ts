import { Component } from '@angular/core';
import { RejestracjaComponent } from './rejestracja/rejestracja'; // Gotowy Formularz

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RejestracjaComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'ogarnijsie-frontend';
}
