package br.com.api.aluguel.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.service.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
