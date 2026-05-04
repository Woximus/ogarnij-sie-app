package pl.Wlodarczyk.ogarnijsie.service;

import org.springframework.stereotype.Service;
import pl.Wlodarczyk.ogarnijsie.dto.RejestracjaDto;
import pl.Wlodarczyk.ogarnijsie.entity.Uzytkownik;
import pl.Wlodarczyk.ogarnijsie.repository.UzytkownikRepository;

import java.time.LocalDateTime;

@Service
public class UzytkownikService {

    private final UzytkownikRepository uzytkownikRepository;

    public UzytkownikService(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public String zarejestruj(RejestracjaDto dto) {

        if (!dto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.pl$")) {
            throw new RuntimeException("Błąd: E-mail musi zawierać znak @ i kończyć się na domenie .pl!");
        }

        if (!dto.getHaslo().matches("^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{12,}$")) {
            throw new RuntimeException("Błąd: Hasło musi mieć min. 12 znaków, w tym jedną wielką literę i znak specjalny!");
        }

        if (!dto.getHaslo().equals(dto.getPowtorzHaslo())) {
            throw new RuntimeException("Błąd: Hasła nie są takie same!");
        }

        if (uzytkownikRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Błąd: Ten adres e-mail jest już zajęty!");
        }

        // Zapis do bazy
        Uzytkownik u = new Uzytkownik();
        u.setImie(dto.getImie());
        u.setNazwisko(dto.getNazwisko());
        u.setEmail(dto.getEmail());
        u.setHaslo(dto.getHaslo());
        u.setDataUtworzenia(LocalDateTime.now());

        uzytkownikRepository.save(u);

        return "Cześć " + dto.getImie() + "! Witamy w Asystencie Dorosłości. Twoje konto zostało utworzone.";
    }
}