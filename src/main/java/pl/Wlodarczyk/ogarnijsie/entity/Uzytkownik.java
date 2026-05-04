package pl.Wlodarczyk.ogarnijsie.entity;

//Narzedzia pozwalajce na komunikacje ( baza danych <--> java )
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Aby zrobila table
@Table(name = "uzytkownik")
public class Uzytkownik {
//nullable = false -> obowiazkowe
//unique = true -> nie moga sie powtarzac
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoinkremetacja
    private Long idUzytkownika;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String haslo;


    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    // Do rodo
    private LocalDateTime dataUtworzenia;



    public Long getIdUzytkownika() { return idUzytkownika; }
    public void setIdUzytkownika(Long idUzytkownika) { this.idUzytkownika = idUzytkownika; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHaslo() { return haslo; }
    public void setHaslo(String haslo) { this.haslo = haslo; }

    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }

    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public LocalDateTime getDataUtworzenia() { return dataUtworzenia; }
    public void setDataUtworzenia(LocalDateTime dataUtworzenia) { this.dataUtworzenia = dataUtworzenia; }
}