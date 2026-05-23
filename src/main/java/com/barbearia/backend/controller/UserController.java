package com.barbearia.backend.controller;

import com.barbearia.backend.entity.User;
import com.barbearia.backend.enums.Role;
import com.barbearia.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User criarUsuario(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    @GetMapping("/barbeiros")
    public List<User> listarBarbeiros() {
        return userRepository.findByRole(Role.BARBEIRO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editar(@PathVariable Long id, @RequestBody User dados) {
        return userRepository.findById(id).map(user -> {
            user.setNome(dados.getNome());
            user.setEmail(dados.getEmail());
            user.setTelefone(dados.getTelefone());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}