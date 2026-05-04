package pl.Wlodarczyk.ogarnijsie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.ogarnijsie.dto.RejestracjaDto;
import pl.Wlodarczyk.ogarnijsie.service.UzytkownikService;

@RestController // Zadania z zewnatrz
@RequestMapping("/api/auth") // Głowny adres
@CrossOrigin(origins = "http://localhost:4200") // Pozwala angularowi na komunikacje
public class AuthApiController {

    private final UzytkownikService uzytkownikService;

    public AuthApiController(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }

    // Odiera dane przeslane przez Post z rejestracji
    @PostMapping("/rejestracja")
    public ResponseEntity<String> rejestracja(@RequestBody RejestracjaDto dto) {
        try {
            String powitanie = uzytkownikService.zarejestruj(dto);
            return ResponseEntity.ok(powitanie);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}