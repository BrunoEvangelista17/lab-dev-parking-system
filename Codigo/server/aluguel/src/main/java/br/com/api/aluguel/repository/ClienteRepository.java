package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
