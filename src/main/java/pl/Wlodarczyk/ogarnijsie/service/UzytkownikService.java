package pl.Wlodarczyk.ogarnijsie.service;

import org.springframework.stereotype.Service;
import pl.Wlodarczyk.ogarnijsie.dto.RejestracjaDto;
import pl.Wlodarczyk.ogarnijsie.entity.Uzytkownik;
import pl.Wlodarczyk.ogarnijsie.repository.UzytkownikRepository;

import java.time.LocalDateTime;

@Service // Logika
public class UzytkownikService {

    private final UzytkownikRepository uzytkownikRepository;

    public UzytkownikService(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    // Proces Rejestracji
    public String zarejestruj(RejestracjaDto dto) {

        // Sprawdza hasla
        if (!dto.getHaslo().equals(dto.getPowtorzHaslo())) {
            throw new RuntimeException("Błąd: Hasła nie są takie same!");
        }

        // Sprawdza maila
        if (uzytkownikRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Błąd: Ten adres e-mail jest już zajęty!");
        }

        // Tworzy czysty rekord
        Uzytkownik u = new Uzytkownik();
        // z dto do bazy
        u.setImie(dto.getImie());
        u.setNazwisko(dto.getNazwisko());
        u.setEmail(dto.getEmail());
        u.setHaslo(dto.getHaslo());
        u.setDataUtworzenia(LocalDateTime.now());

        // Na stale do bazy
        uzytkownikRepository.save(u);

        // Powitanie
        return "Cześć " + dto.getImie() + "! Witamy w Asystencie Dorosłości. Twoje konto zostało utworzone.";
    }
}