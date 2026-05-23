package com.barbearia.backend.controller;

import com.barbearia.backend.entity.Servico;
import com.barbearia.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @PostMapping
    public Servico criarServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> editar(@PathVariable Long id, @RequestBody Servico dados) {
        return servicoRepository.findById(id).map(servico -> {
            servico.setNome(dados.getNome());
            servico.setPreco(dados.getPreco());
            servico.setDuracao(dados.getDuracao());
            return ResponseEntity.ok(servicoRepository.save(servico));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}