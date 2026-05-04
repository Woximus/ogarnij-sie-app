package pl.Wlodarczyk.ogarnijsie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.Wlodarczyk.ogarnijsie.entity.Uzytkownik;

@Repository // Informuje ze komunikuje sie z baza
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {

    // Spring sprawdza czy email istnieje
    boolean existsByEmail(String email);
}