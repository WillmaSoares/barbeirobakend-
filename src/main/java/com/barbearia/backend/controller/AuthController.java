package com.barbearia.backend.controller;

import com.barbearia.backend.entity.User;
import com.barbearia.backend.repository.UserRepository;
import com.barbearia.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    // RF02 — Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty() || !user.get().getSenha().equals(senha)) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }

        String token = jwtService.gerarToken(email);
        return ResponseEntity.ok(Map.of(
                "token", token,
                "nome", user.get().getNome(),
                "role", user.get().getRole()
        ));
    }

    // RF02 — Logout
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout realizado com sucesso");
    }
}