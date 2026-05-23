package com.barbearia.backend.controller;

import com.barbearia.backend.entity.Agendamento;
import com.barbearia.backend.enums.StatusAgendamento;
import com.barbearia.backend.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    // RF05 — criar agendamento
    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        Agendamento salvo = repository.save(agendamento);
        return repository.findByIdComDados(salvo.getId()).orElse(salvo);
    }

    // RF15 — listar todos os agendamentos
    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAllComDados();
    }

    // RF08 — cancelar agendamento
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Agendamento> cancelar(@PathVariable Long id) {
        return repository.findById(id).map(ag -> {
            ag.setStatus(StatusAgendamento.CANCELADO);
            return ResponseEntity.ok(repository.save(ag));
        }).orElse(ResponseEntity.notFound().build());
    }

    // RF08 — remarcar agendamento
    @PatchMapping("/{id}/remarcar")
    public ResponseEntity<Agendamento> remarcar(
            @PathVariable Long id,
            @RequestBody Agendamento dados) {
        return repository.findById(id).map(ag -> {
            ag.setDataHora(dados.getDataHora());
            ag.setStatus(StatusAgendamento.AGENDADO);
            return ResponseEntity.ok(repository.save(ag));
        }).orElse(ResponseEntity.notFound().build());
    }

    // RF18 — histórico de atendimentos concluídos
    @GetMapping("/historico")
    public List<Agendamento> historico() {
        return repository.findByStatus(StatusAgendamento.CONCLUIDO);
    }

    // RF09 — Confirmar realização de serviço
    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Agendamento> concluir(@PathVariable Long id) {
        return repository.findById(id).map(ag -> {
            ag.setStatus(StatusAgendamento.CONCLUIDO);
            return ResponseEntity.ok(repository.save(ag));
        }).orElse(ResponseEntity.notFound().build());
    }


}