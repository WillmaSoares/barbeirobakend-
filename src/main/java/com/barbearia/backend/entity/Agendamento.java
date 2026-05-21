package com.barbearia.backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //cliente
    @ManyToOne
    private User cliente;

    //barbeiro
    @ManyToOne
    private User barbeiro;

    //serviço
    @ManyToOne
    private Servico servico;

    //Data e hora
    private LocalDateTime dataHora;
}
