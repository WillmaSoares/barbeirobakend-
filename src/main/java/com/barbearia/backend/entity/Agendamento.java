package com.barbearia.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"senha", "email", "telefone"})
    private User cliente;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    @JsonIgnoreProperties({"senha", "email", "telefone"})
    private User barbeiro;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    private LocalDateTime dataHora;
}