package com.barbearia.backend.entity;

import com.barbearia.backend.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String telefone;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;
}