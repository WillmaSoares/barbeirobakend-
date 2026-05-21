package com.barbearia.backend.repository;
import com.barbearia.backend.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServicoRepository extends JpaRepository<Servico, Long>{
}
