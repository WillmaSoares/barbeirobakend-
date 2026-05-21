package com.barbearia.backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@table(name = "agendamento")
public class agendamento {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Log id;

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
    private LocalDataTime dataHora;
}
