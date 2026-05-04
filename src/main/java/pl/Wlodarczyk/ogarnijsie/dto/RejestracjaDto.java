package pl.Wlodarczyk.ogarnijsie.dto;

public class RejestracjaDto {
    // Idetyczne jak w angularze !!!
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String powtorzHaslo;


    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }

    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHaslo() { return haslo; }
    public void setHaslo(String haslo) { this.haslo = haslo; }

    public String getPowtorzHaslo() { return powtorzHaslo; }
    public void setPowtorzHaslo(String powtorzHaslo) { this.powtorzHaslo = powtorzHaslo; }
}