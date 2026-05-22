package com.barbearia.backend.controller;

import com.barbearia.backend.entity.Agendamento;
import com.barbearia.backend.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        Agendamento salvo = repository.save(agendamento);
        return repository.findByIdComDados(salvo.getId()).orElse(salvo);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAllComDados();
    }
}