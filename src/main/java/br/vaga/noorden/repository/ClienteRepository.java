package br.vaga.noorden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.vaga.noorden.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}