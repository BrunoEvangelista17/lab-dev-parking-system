package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.model.ClienteEntity;


public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
