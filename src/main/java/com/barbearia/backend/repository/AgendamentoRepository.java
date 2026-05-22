package com.barbearia.backend.repository;

import com.barbearia.backend.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.barbearia.backend.enums.StatusAgendamento;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("SELECT a FROM Agendamento a JOIN FETCH a.cliente JOIN FETCH a.barbeiro JOIN FETCH a.servico")
    List<Agendamento> findAllComDados();

    @Query("SELECT a FROM Agendamento a JOIN FETCH a.cliente JOIN FETCH a.barbeiro JOIN FETCH a.servico WHERE a.id = :id")
    Optional<Agendamento> findByIdComDados(Long id);

    @Query("SELECT a FROM Agendamento a JOIN FETCH a.cliente JOIN FETCH a.barbeiro JOIN FETCH a.servico WHERE a.status = :status")
    List<Agendamento> findByStatus(StatusAgendamento status);
}