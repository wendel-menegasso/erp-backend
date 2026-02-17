package br.com.erp.seguranca.adapter.controller;

import br.com.erp.seguranca.domain.entity.Token;
import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.usecases.auth.LoadUserByUsernameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final LoadUserByUsernameUseCase useCase;

    public UserController(LoadUserByUsernameUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasAuthority('/admin/dashboard')")
    public ResponseEntity<?> adminDashboard() {
        return ResponseEntity.ok("Area Admin!");
    }

    @GetMapping("/user/profile")
    @PreAuthorize("hasAuthority('/user/profile')")
    public String userProfile() {
        return "Perfil do usuário";
    }

    @PostMapping("public/login")
    public ResponseEntity<?> getLogin(@RequestBody LoginRequest request) {
        Optional<User> user = useCase.executar(request.getUsername(), request.getPassword());

        String token = new Token().generateToken(request.getUsername());

        Map<String, String> resposta = new HashMap<>();
        resposta.put("token", token);


        if (user.isPresent()) return ResponseEntity.ok(resposta);
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
