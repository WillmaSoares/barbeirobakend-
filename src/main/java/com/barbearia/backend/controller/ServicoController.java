package com.barbearia.backend.controller;
import com.barbearia.backend.entity.Servico;
import com.barbearia.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoRepository servicoRepository;

    @PostMapping
    public Servico criarServico(@RequestBody Servico servico){
        return servicoRepository.save(servico);
    }

    @GetMapping
    public List<Servico> listarServicos(){
        return servicoRepository.findAll();
    }
}
