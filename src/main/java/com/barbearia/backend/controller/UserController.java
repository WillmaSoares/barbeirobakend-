package com.barbearia.backend.controller;
import com.barbearia.backend.enums.Role;
import com.barbearia.backend.entity.User;
import com.barbearia.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> listarBarbeiro(){
        return userRepository.findByRole(Role.BARBEIRO);

    }
}