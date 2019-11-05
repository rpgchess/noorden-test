package br.vaga.noorden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.vaga.noorden.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {}