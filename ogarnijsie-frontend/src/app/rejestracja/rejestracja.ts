import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-rejestracja',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './rejestracja.html',
  styleUrl: './rejestracja.css'
})
export class RejestracjaComponent {
  uzytkownik = {
    imie: '',
    nazwisko: '',
    email: '',
    haslo: '',
    powtorzHaslo: ''
  };

  wiadomosc = '';
  blad = '';

  constructor(private http: HttpClient) {}

  onSubmit(formularz: any) {
    this.wiadomosc = '';
    this.blad = '';

    this.http.post('http://localhost:8080/api/auth/rejestracja', this.uzytkownik, { responseType: 'text' })
      .subscribe({
        next: () => {
          this.wiadomosc = 'Cześć ' + this.uzytkownik.imie + '! Witamy w Asystencie Dorosłości. Twoje konto zostało utworzone.';
        },
        error: (err) => {
          if (err.status === 0) {
            this.blad = "Błąd krytyczny: Brak połączenia z serwerem Javy!";
          } else {
            this.blad = typeof err.error === 'string' ? err.error : 'Wystąpił nieznany błąd.';
          }
        }
      });
  }
}
